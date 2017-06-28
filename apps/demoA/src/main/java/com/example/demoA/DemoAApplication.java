package com.example.demoA;

import com.example.commons.LoadCommonBeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@LoadCommonBeans
public class DemoAApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAApplication.class, args);
	}

}
