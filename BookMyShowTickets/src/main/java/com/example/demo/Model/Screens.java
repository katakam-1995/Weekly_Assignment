package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "master_screen")

public class Screens implements Serializable{

	@Id
	private int screenId;
	
	private String screenName;

	private String screenStatus;
	
	public String getScreenStatus() {
		return screenStatus;
	}

	public void setScreenStatus(String screenStatus) {
		this.screenStatus = screenStatus;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	
	
}
