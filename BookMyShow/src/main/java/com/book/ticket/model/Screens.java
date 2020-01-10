package com.book.ticket.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "master_screen")

public class Screens implements Serializable {

	@Id
	private String id;

	private String screenId;

	private String screenName;

	private String screenStatus;

	private int count;

	private List<String> timings;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getTimings() {
		return timings;
	}

	public void setTimings(List<String> timings) {
		this.timings = timings;
	}

	public String getScreenStatus() {
		return screenStatus;
	}

	public void setScreenStatus(String screenStatus) {
		this.screenStatus = screenStatus;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

}
