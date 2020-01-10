package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.InputVO;
import com.example.demo.Model.MovieScreenAlloted;
import com.example.demo.Model.Movies;
import com.example.demo.serviceimpl.MovieServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieServiceImpl movieServiceImpl;

	@GetMapping("getmovieList")
	public List<Movies> getmovieList() {

		List<Movies> movieList = movieServiceImpl.getmovieList();

		return movieList;

	}
	
	@PostMapping("getmovieDetails")
	public void getmovieDetails() {

		movieServiceImpl.save();


	}
	
	@PostMapping("getAvailableSeatsDetails")
	public InputVO getAvailableSeatsDetails(@RequestBody InputVO vo) {

		InputVO voList=movieServiceImpl.getAvailableSeatsDetails(vo);
		return voList;

	}
	
	/*
	 * @GetMapping("getmovieAvailableList") public List<MovieScreenAlloted>
	 * getmovieAvailableList(@RequestBody InputVO vo) {
	 * 
	 * List<MovieScreenAlloted> movieList =
	 * movieServiceImpl.getmovieAvailableList(vo);
	 * 
	 * return movieList;
	 * 
	 * }
	 */

}
