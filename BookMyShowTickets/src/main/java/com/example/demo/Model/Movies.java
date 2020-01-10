package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "master_movie")

public class Movies implements Serializable{

	@Id
	private Long id;

	private int movieId;
	
	private String movieName;
	
	private String Status;
	
	private String movieImage;
	
	private String movieContent;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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
