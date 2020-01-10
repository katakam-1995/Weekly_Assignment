package com.example.demo.Model;

import java.time.LocalDate;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonFormat;

public class InputVO {
private int id;
//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate inputDate;

private String userName;

private String password;

private String role;

private boolean login;

private String screenName;

private String screenTiming;

private List<String> seats;



public List<String> getSeats() {
	return seats;
}
public void setSeats(List<String> seats) {
	this.seats = seats;
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
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public boolean isLogin() {
	return login;
}
public void setLogin(boolean login) {
	this.login = login;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public LocalDate getInputDate() {
	return inputDate;
}
public void setInputDate(LocalDate inputDate) {
	this.inputDate = inputDate;
}

}
