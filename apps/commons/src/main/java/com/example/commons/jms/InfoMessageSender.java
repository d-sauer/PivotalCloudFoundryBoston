package com.example.commons.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class InfoMessageSender {

    private static final Logger logger = LoggerFactory.getLogger(InfoMessageSender.class);

    private JmsTemplate jmsTemplate;

    @Value("${demo.destinationName}")
    private String destinationName;

    public InfoMessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(InfoMessage message) {
        logger.debug("Sending message: ({}) {}", message.getFrom(), message.getMessage());
        jmsTemplate.convertAndSend(destinationName, message);
    }
}
