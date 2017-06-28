package com.example.commons.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class InfoMessageReceiver {

    private static final Logger logger = LoggerFactory.getLogger(InfoMessageReceiver.class);

    @JmsListener(destination = "${demo.listenerQueueName}")
    public void infoMessageReceiver(InfoMessage infoMessage) {
        logger.info("Receive info message: {}", infoMessage);
    }

}
