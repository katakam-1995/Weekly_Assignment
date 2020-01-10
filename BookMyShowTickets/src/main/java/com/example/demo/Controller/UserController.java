package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.InputVO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.serviceimpl.MovieServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class UserController {

	@Autowired
	private MovieServiceImpl movieServiceImpl;

	/*
	 * @PostMapping("/admin") public ResponseEntity<Boolean>
	 * getAdminString(@RequestBody InputVO vo) throws Exception{ boolean flag=true;
	 * if(flag) { return ResponseEntity.status(HttpStatus.OK).body(flag); } throw
	 * new Exception("Unautherized User"); }
	 */

	@PostMapping("/getAuthorizedUser")
	public ResponseEntity<InputVO> getAuthorizedUser(@RequestBody InputVO vo) throws Exception {
		InputVO user = movieServiceImpl.getAuthorizedUser(vo);
		if (user != null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		throw new ResourceNotFoundException("Unautherized User");
	}

}
