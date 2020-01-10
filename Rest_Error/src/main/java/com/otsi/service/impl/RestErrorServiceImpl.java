package com.otsi.service.impl;

import org.springframework.stereotype.Service;

import com.otsi.service.RestErrorService;

@Service
public class RestErrorServiceImpl implements RestErrorService{

	@Override
	public String getErrorService() {
		return "Error";
	}

}
