package com.otsi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.model.Employee;
import com.otsi.service.EmployeeService;

@RestController
public class EmployeeServiceController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/findEmployeeDetails/{employeeId}", method = RequestMethod.GET)
	public Optional<Employee> getEmployeeDetails(@PathVariable int employeeId) {
		System.out.println("Getting Employee details for " + employeeId);

		Optional<Employee> employee = employeeService.getEmployee(employeeId);
		
		return employee;
	}
}
