package com.otsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
