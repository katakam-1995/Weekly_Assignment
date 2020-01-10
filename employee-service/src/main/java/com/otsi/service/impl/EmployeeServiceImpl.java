package com.otsi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otsi.model.Employee;
import com.otsi.repository.EmployeeDAO;
import com.otsi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Optional<Employee> getEmployee(int employeeId) {
		Optional<Employee> emp=employeeDAO.findById(employeeId);
		return emp;
	}

}
