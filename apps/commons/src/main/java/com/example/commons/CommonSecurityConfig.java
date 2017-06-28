package com.example.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@ConditionalOnMissingBean(value = WebSecurityConfigurerAdapter.class)
@EnableWebSecurity
public class CommonSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(CommonSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("HttpSecurity configuration");
        http
                .formLogin().disable()
                .httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.debug("Create in memory users");
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN", "ACTUATOR");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        logger.debug("Create User detail service");
        return super.userDetailsServiceBean();
    }
}
