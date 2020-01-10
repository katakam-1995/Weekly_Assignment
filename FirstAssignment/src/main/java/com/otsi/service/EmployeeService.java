package com.otsi.service;

import java.util.List;

import com.otsi.model.EmployeeVO;

public interface EmployeeService {
	List<EmployeeVO> saveEmployeeDetails(List<EmployeeVO> empVo);
}
