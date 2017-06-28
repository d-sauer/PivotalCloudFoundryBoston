package com.example.commons;

import com.example.commons.jms.JmsSendRestController;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.client.RestTemplate;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
@ComponentScan(basePackageClasses = JmsSendRestController.class)
@Import({CommonSecurityConfig.class})
public class CommonsConfig {

    @Bean
    public InfoBean infoBean() {
        return new InfoBean();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("object-type");

        return converter;
    }

    @Bean
    public JmsTemplate jmsTemplate(MessageConverter jsonMessageConverter, ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter);

        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory(
            DefaultJmsListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());

        return factory;
    }

}
