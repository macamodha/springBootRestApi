package com.chulan.springBootRestApi.service;

import java.util.List;

import com.chulan.springBootRestApi.model.Employee;

public interface EmployeeService {
	
	Employee save(Employee emp);
	List<Employee> findAll();
	Employee findOne(Long empId);
	void deleteEmp(Employee emp);
}
