package com.example.demoA;

import com.example.commons.LoadCommonConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@LoadCommonConfig
public class DemoAApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAApplication.class, args);
	}

}
