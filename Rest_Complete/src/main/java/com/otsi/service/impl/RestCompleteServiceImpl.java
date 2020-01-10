package com.otsi.service.impl;

import org.springframework.stereotype.Service;

import com.otsi.service.RestCompleteService;

@Service
public class RestCompleteServiceImpl implements RestCompleteService{

	@Override
	public String getCompleteService() {
		return "Completed";
	}
	
}
