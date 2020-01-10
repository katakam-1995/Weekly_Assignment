package com.otsi.config;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopConfig {

	private Logger log = LoggerFactory.getLogger(AopConfig.class);

	@AfterThrowing(pointcut = "execution(* com.otsi.controller.EmployeeController.getAllEmployeeDetailsStatus(..))", throwing = "ex")
	public void print(Exception ex) {
		System.out.println(ex.getMessage());
	}
}
