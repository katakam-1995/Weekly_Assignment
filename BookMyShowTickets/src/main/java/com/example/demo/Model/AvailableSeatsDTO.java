package com.example.demo.Model;

import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "available_seats")
public class AvailableSeatsDTO {

	@Id
	private String id;
	private String rowCount;
	private String colCount;
	private List<Map<String,List<Map<String,String>>>> rows;
	private List<Map<String,String>> rowamount;
	private String screenName;
	private String screenTiming;
	
	
	@Override
	public String toString() {
		return "AvailableSeatsDTO [id=" + id + ", rowCount=" + rowCount + ", colCount=" + colCount + ", rows=" + rows
				+ ", rowamount=" + rowamount + ", screenName=" + screenName + ", screenTiming=" + screenTiming + "]";
	}
	public AvailableSeatsDTO() {
		super();
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
	
	public List<Map<String, String>> getRowamount() {
		return rowamount;
	}
	public void setRowamount(List<Map<String, String>> rowamount) {
		this.rowamount = rowamount;
	}
	public String getScreenName() {
		return screenName;
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
	
}
