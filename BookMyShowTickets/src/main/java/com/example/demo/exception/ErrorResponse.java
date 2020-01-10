package com.example.demo.exception;

import java.util.List;

public class ErrorResponse {
	
	private boolean login;
	
	private String message;
 
    private List<String> details;

	public String getMessage() {
		return message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
 
	
	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public ErrorResponse(boolean login, String message, List<String> details) {
		super();
		this.login = login;
		this.message = message;
		this.details = details;
	}

}
