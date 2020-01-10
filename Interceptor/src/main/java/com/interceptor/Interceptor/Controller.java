package com.interceptor.Interceptor;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class Controller {
	
	  private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@RequestMapping("name")
	public String getName() {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity requestEntity = new HttpEntity(headers);
		restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
		//restTemplate.exchange("http://localhost:8080/hello/name", HttpMethod.POST, requestEntity, Response.class);
		log.info("controller Enter ");
		return "(name)";
	}

	@RequestMapping("id")
	public String getid() {
		return "(id)";
	}

}
