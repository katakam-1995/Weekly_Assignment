package com.book.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.ticket.service.MovieService;
import com.book.ticket.vo.InputVO;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class UserController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/getAuthorizedUser")
	public ResponseEntity<InputVO> getAuthorizedUser(@RequestBody InputVO vo) throws Exception {
		boolean flag = false;
		InputVO user = movieService.getAuthorizedUser(vo);
		if (user != null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			vo.setLogin(flag);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
		}
	}

}
