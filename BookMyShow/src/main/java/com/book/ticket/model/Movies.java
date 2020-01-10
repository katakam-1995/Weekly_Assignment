package com.book.ticket.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "master_movie")

public class Movies implements Serializable {

	@Id
	private Long movieId;

	private String movieName;

	private String status;

	private String movieImage;

	private String movieContent;

	public Long getMovieId() {
		return movieId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
