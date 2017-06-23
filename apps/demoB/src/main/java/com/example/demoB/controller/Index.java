package com.example.demoB.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Index {

    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Map<String, Object> index() {
        logger.info("GET index");

        Map<String, Object> data = new HashMap<>();

        data.put("appName", appName);
        data.put("time", LocalDateTime.now().toString());

        return data;
    }


}
