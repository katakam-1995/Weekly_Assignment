package com.example.demo.Model;

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

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate selectedDate;

	private String selectedTiming;

	private String selectedScreen;
	
	private Map<String,String> selectedSeats;

	private Map<String, List<String>> selectedrows;

	public Map<String, String> getSelectedSeats() {
		return selectedSeats;
	}
	public void setSelectedSeats(Map<String, String> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	private Double totalamount;
	private Long movieId;
	private String movieImage;
	private String movieContent;
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
	public String getSelectedScreen() {
		return selectedScreen;
	}
	public void setSelectedScreen(String selectedScreen) {
		this.selectedScreen = selectedScreen;
	}
	public Map<String, List<String>> getSelectedrows() {
		return selectedrows;
	}
	public void setSelectedrows(Map<String, List<String>> selectedrows) {
		this.selectedrows = selectedrows;
	}
	public Double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}
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
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", movieName=" + movieName + ", selectedDate=" + selectedDate
				+ ", selectedTiming=" + selectedTiming + ", selectedScreen=" + selectedScreen + ", selectedrows="
				+ selectedrows + ", totalamount=" + totalamount + ", movieId=" + movieId + ", movieImage=" + movieImage
				+ ", movieContent=" + movieContent + "]";
	}
	public UserDetails() {
		super();
	}
	
	

}
