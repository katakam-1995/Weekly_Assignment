package com.book.ticket.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

//import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "available_seats")

public class AvailableSeats {
	@Id
	private String id;
	private String rowCount;
	private String colCount;
	private List<Map<String, List<Map<String, String>>>> rows;
	private Map<String, String> rowamount;

	private String screenName;
	private String screenTiming;

	public String getScreenName() {
		return screenName;
	}

	public Map<String, String> getRowamount() {
		return rowamount;
	}

	public void setRowamount(Map<String, String> rowamount) {
		this.rowamount = rowamount;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenTiming() {
		return screenTiming;
	}

	public void setScreenTiming(String screenTiming) {
		this.screenTiming = screenTiming;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRowCount() {
		return rowCount;
	}

	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}

	public String getColCount() {
		return colCount;
	}

	public void setColCount(String colCount) {
		this.colCount = colCount;
	}

	public List<Map<String, List<Map<String, String>>>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, List<Map<String, String>>>> rows) {
		this.rows = rows;
	}

}
