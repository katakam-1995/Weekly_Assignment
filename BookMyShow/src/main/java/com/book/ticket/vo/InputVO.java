package com.book.ticket.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class InputVO implements Serializable {

	private Long movieId;
	private Map<String, String> rowamount;

	private Map<String, Integer> totalSeatsCount;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Map<String, String> getRowamount() {
		return rowamount;
	}

	public void setRowamount(Map<String, String> rowamount) {
		this.rowamount = rowamount;
	}

	public Map<String, Integer> getTotalSeatsCount() {
		return totalSeatsCount;
	}

	public void setTotalSeatsCount(Map<String, Integer> totalSeatsCount) {
		this.totalSeatsCount = totalSeatsCount;
	}

	private Map<String, List<String>> selectedSeats;
	private Map<String, List<Integer>> rows;

	public Map<String, List<Integer>> getRows() {
		return rows;
	}

	public void setRows(Map<String, List<Integer>> rows) {
		this.rows = rows;
	}

	public Long getMovieId() {
		return movieId;
	}

	public Map<String, List<String>> getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(Map<String, List<String>> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieContent() {
		return movieContent;
	}

	public void setMovieContent(String movieContent) {
		this.movieContent = movieContent;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer id;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// @JsonFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fromdate;

	private Map<String, String> screens;
	private Map<String, List<String>> timings;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// @JsonFormat(pattern = "dd-MM-yyyy")

	private LocalDate todate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	private String movieName;

	private String movieImage;
	private String movieContent;
	private String screenName;
	private List<String> showTimmings;
	private String selectedTiming;

	private String userName;

	private String password;

	private String role;

	private boolean login;

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

	public String getSelectedTiming() {
		return selectedTiming;
	}

	public void setSelectedTiming(String selectedTiming) {
		this.selectedTiming = selectedTiming;
	}

	public List<String> getShowTimmings() {
		return showTimmings;
	}

	public void setShowTimmings(List<String> showTimmings) {
		this.showTimmings = showTimmings;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public Map<String, List<String>> getTimings() {
		return timings;
	}

	public void setTimings(Map<String, List<String>> timings) {
		this.timings = timings;
	}

	public Map<String, String> getScreens() {
		return screens;
	}

	public void setScreens(Map<String, String> screens) {
		this.screens = screens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFromdate() {
		return fromdate;
	}

	public void setFromdate(LocalDate fromdate) {
		this.fromdate = fromdate;
	}

	public LocalDate getTodate() {
		return todate;
	}

	public void setTodate(LocalDate todate) {
		this.todate = todate;
	}

}
