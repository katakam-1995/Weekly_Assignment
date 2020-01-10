package com.otsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.service.impl.RestCompleteServiceImpl;

@RestController
@RequestMapping("/RestComplete")
public class RestCompleteController {
	
	@Autowired
	private RestCompleteServiceImpl restCompleteServiceImpl;
	
	@GetMapping("/complete")
	public  String getCompleteService() {
		String complete=restCompleteServiceImpl.getCompleteService();
		return complete;		
	}
	
}
