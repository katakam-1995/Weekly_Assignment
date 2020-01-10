package com.otsi.service.impl;

import org.springframework.stereotype.Service;

import com.otsi.service.RestResolveService;

@Service
public class RestResolveServiceImpl implements RestResolveService{

	@Override
	public String getResolveService() {
		return "Resolved";
	}

}
