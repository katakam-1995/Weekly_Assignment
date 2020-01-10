package com.otsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.service.impl.RestErrorServiceImpl;

@RestController
@RequestMapping("/restError")
public class RestErrorController {
	
	@Autowired
	private RestErrorServiceImpl restCompleteServiceImpl;
	
	@GetMapping("/error")
	public String getErrorService() {
		String error=restCompleteServiceImpl.getErrorService();
		return error;		
	}
	
}
