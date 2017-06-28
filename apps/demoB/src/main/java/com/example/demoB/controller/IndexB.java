package com.example.demoB.controller;

import com.example.commons.InfoBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexB {

    private static final Logger logger = LoggerFactory.getLogger(IndexB.class);

    private InfoBean infoBean;

    private RestTemplate restTemplate;

    public IndexB(InfoBean infoBean, RestTemplate restTemplate) {
        this.infoBean = infoBean;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Map<String, Object> index() {
        logger.info("GET index");

        return infoBean.info();
    }


    @GetMapping("/service")
    public Object service(@RequestParam("uri") String uri) {
        logger.info("get URI '{}'", uri);

        Object forObject = restTemplate.getForObject(uri, Object.class);


        return forObject;
    }

}
