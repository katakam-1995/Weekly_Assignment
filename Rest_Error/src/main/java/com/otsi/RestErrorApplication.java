package com.otsi;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.otsi.*")
public class RestErrorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestErrorApplication.class, args);
	}

}
