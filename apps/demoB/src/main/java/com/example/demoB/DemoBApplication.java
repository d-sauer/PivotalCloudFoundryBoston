package com.example.demoB;

import com.example.commons.LoadCommonConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@LoadCommonConfig
public class DemoBApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBApplication.class, args);
	}
}
