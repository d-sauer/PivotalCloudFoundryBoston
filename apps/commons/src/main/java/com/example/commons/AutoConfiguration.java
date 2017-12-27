package com.example.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfiguration  {

    @Bean
    public DiscoveryClientMetadata discoveryClientMetadata() {
        return new DiscoveryClientMetadata();
    }

}
