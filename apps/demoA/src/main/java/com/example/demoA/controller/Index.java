package com.example.demoA.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Index {

    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    public Index(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Map<String, Object> index() {
        logger.info("GET index");

        Map<String, Object> data = new HashMap<>();

        data.put("appName", appName);
        data.put("time", LocalDateTime.now().toString());

        return data;
    }


    @GetMapping("/service")
    public Object service(@RequestParam("uri") String uri) {
        logger.info("get URI '{}'", uri);

        Object forObject = restTemplate.getForObject(uri, Object.class);


        return forObject;
    }

}
