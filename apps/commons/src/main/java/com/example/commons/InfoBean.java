package com.example.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * @author Davor Sauer
 */
@Component
@Getter
public class InfoBean {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${cloud.application.application_version:none}")
    private String cloudAppVersion;

    @Value("${cloud.application.instance-id:none}")
    private String cloudInstanceId;

    @Value("${cloud.application.instance_index:none}")
    private String cloudInstanceIndex;


    public Map<String, Object> info() {
        Map<String, Object> info = new HashMap<>();

        info.put("time", LocalDateTime.now().toString());
        info.put("appName", appName);
        info.put("cloudAppVersion", cloudAppVersion);
        info.put("cloudInstanceId", cloudInstanceId);
        info.put("cloudInstanceIndex", cloudInstanceIndex);

        return info;
    }

}
