package com.book.ticket.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "userDetails")
public class UserDetails {

	@Id
	private Long userId;

	private String movieName;

	@JsonFormat(pattern = "yyyy-MM-dd")

	private LocalDate selectedDate;

	private String selectedTiming;

	private String selectedScreen;

	private Map<String, List<String>> selectedrows;

	private Double totalamount;
	private Long movieId;
	private String movieImage;
	private String movieContent;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public String getMovieContent() {
		return movieContent;
	}

	public void setMovieContent(String movieContent) {
		this.movieContent = movieContent;
	}

	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}

	public Map<String, List<String>> getSelectedrows() {
		return selectedrows;
	}

	public void setSelectedrows(Map<String, List<String>> selectedrows) {
		this.selectedrows = selectedrows;
	}

	public Map<String, String> getRowamount() {
		return rowamount;
	}

	public void setRowamount(Map<String, String> rowamount) {
		this.rowamount = rowamount;
	}

	private Map<String, String> rowamount;

	public String getSelectedScreen() {
		return selectedScreen;
	}

	public void setSelectedScreen(String selectedScreen) {
		this.selectedScreen = selectedScreen;
	}

	private Map<String, List<String>> selectedSeats;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDate getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(LocalDate selectedDate) {
		this.selectedDate = selectedDate;
	}

	public String getSelectedTiming() {
		return selectedTiming;
	}

	public void setSelectedTiming(String selectedTiming) {
		this.selectedTiming = selectedTiming;
	}

	public Map<String, List<String>> getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(Map<String, List<String>> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
}
