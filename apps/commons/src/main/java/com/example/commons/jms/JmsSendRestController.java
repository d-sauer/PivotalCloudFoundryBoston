package com.example.commons.jms;

import com.example.commons.InfoBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/jms")
public class JmsSendRestController {

    private static final Logger logger = LoggerFactory.getLogger(JmsSendRestController.class);

    private InfoMessageSender infoMessageSender;

    private InfoBean infoBean;

    public JmsSendRestController(InfoMessageSender infoMessageSender, InfoBean infoBean) {
        this.infoMessageSender = infoMessageSender;
        this.infoBean = infoBean;
    }

    /**
     * Example request: http "localhost:8081/jms/ping"
     */
    @GetMapping("/ping")
    public InfoMessage ping() {
        logger.trace("REST ping");

        InfoMessage message = new InfoMessage(infoBean.getAppName(), LocalDateTime.now().toString());
        infoMessageSender.send(message);

        return message;
    }

    /**
     * Example request:
     * @param message
     * @return
     */
    @PostMapping("/send")
    public InfoMessage send(SendMessageDTO message) {
        logger.trace("REST send");

        InfoMessage jmsMessage = new InfoMessage(infoBean.getAppName(), message.getMessage());
        infoMessageSender.send(jmsMessage);

        return jmsMessage;
    }

}
