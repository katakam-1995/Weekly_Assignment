package com.example.demo.Model;

import java.time.LocalDate;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "master_show_timings")

public class ShowTimings {

	@Id
	private int showId;
	
	private LocalDate showTime;

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDate showTime) {
		this.showTime = showTime;
	}
}
