package com.otsi.service;

import java.util.Optional;

import com.otsi.model.Employee;

public interface EmployeeService {

	Optional<Employee> getEmployee(int employeeId);

}
