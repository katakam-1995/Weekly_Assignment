package com.otsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.exception.ResourceNotFoundException;
import com.otsi.model.EmployeeVO;
import com.otsi.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empServiceImpl;

	@PostMapping(value = "/saveEmployeeDetails")
	public ResponseEntity<List<EmployeeVO>> saveEmployeeDetails(@RequestBody List<EmployeeVO> empVo) throws Exception {
		if (!empVo.isEmpty()) {
			List<EmployeeVO> employeeDetails = empServiceImpl.saveEmployeeDetails(empVo);
			return ResponseEntity.status(HttpStatus.OK).body(employeeDetails);
		}
		throw new ResourceNotFoundException("No Input Found");
	}

	@GetMapping("/getAllEmployeeDetailsStatus")
	public void getAllEmployeeDetailsStatus(@RequestParam String status) throws InterruptedException {

		if (!status.isEmpty()) {
			empServiceImpl.getAllEmployeeDetailsStatus(status);
		}
		throw new ResourceNotFoundException("No Status Found");

	}

}
