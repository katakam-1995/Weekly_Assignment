package com.book.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.ticket.model.MovieScreenAlloted;
import com.book.ticket.model.Movies;
import com.book.ticket.model.Screens;
import com.book.ticket.service.MovieService;
import com.book.ticket.serviceimpl.MovieServiceImpl;
import com.book.ticket.vo.InputVO;

@CrossOrigin
@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("getmovieList")
	public GateWayResponse<List<Movies>> getmovieList() {

		List<Movies> movieList = (List<Movies>) movieService.getmovieList();

		return new GateWayResponse<List<Movies>>(HttpStatus.OK, movieList, "Success");

	}

	@GetMapping("showavailableScreenandTimings")
	public GateWayResponse<?> showavailableScreenandTimings() {
		InputVO showavailableScreenandTimings = movieService.showavailableScreenandTimings();
		return new GateWayResponse<>(HttpStatus.OK, showavailableScreenandTimings, "Success");
	}

	@PostMapping("savingMovie")
	public GateWayResponse<?> savingMovie(@RequestBody InputVO vo) throws Exception {
		movieService.savingMovie(vo);
		return new GateWayResponse<>(HttpStatus.OK, "Success", "Success");

	}

	@PostMapping("deleteMovie")
	public GateWayResponse<?> deleteMovie(@RequestBody InputVO vo) throws Exception {
		movieService.deleteMovie(vo);

		return new GateWayResponse<>(HttpStatus.OK, "Success", "Success");

	}

	@PostMapping("showAvailScreen")
	public GateWayResponse<?> showAvailScreen(@RequestBody InputVO vo) throws Exception {

		return new GateWayResponse<>(HttpStatus.OK, movieService.showAvailScreen(vo), "Success");

	}

	@PostMapping("showAvailableSeats")
	public GateWayResponse<?> showAvailableSeats(@RequestBody InputVO vo) {
		InputVO showAvailableSeats = movieService.showAvailableSeats(vo);
		return new GateWayResponse<>(HttpStatus.OK, showAvailableSeats, "Success");
	}

	@PostMapping("saveseat")
	public GateWayResponse<?> saveseat() {
		movieService.saveseat();
		return new GateWayResponse<>(HttpStatus.OK, "Success", "Success");
	}

	@PostMapping("saveUserDetails")
	public GateWayResponse<?> saveUserDetails(@RequestBody InputVO vo) throws Exception {
		InputVO saveUserDetails = movieService.saveUserDetails(vo);
		return new GateWayResponse<>(HttpStatus.OK, saveUserDetails, "Success");

	}

}
