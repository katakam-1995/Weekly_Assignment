package com.otsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RestCompleteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCompleteApplication.class, args);
	}

}
