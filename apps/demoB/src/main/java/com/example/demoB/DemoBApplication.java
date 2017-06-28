package com.example.demoB;

import com.example.commons.LoadCommonBeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@LoadCommonBeans
public class DemoBApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBApplication.class, args);
	}
}
