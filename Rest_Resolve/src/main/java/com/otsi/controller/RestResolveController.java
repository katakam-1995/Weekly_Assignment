package com.otsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.service.impl.RestResolveServiceImpl;

@RestController
@RequestMapping("/RestResolve")
public class RestResolveController {
	
	@Autowired
	private RestResolveServiceImpl restResolveServiceImpl;
	
	@GetMapping("/resolve")
	public String getErrorService() {
		String error=restResolveServiceImpl.getResolveService();
		return error;		
	}
	
}
