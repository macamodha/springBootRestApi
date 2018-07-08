package com.chulan.springBootRestApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chulan.springBootRestApi.model.Employee;
import com.chulan.springBootRestApi.repositary.EmployeeRepository;
import com.chulan.springBootRestApi.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findOne(Long empId) {
		return employeeRepository.findOne(empId);
	}

	@Override
	public void deleteEmp(Employee emp) {
		employeeRepository.delete(emp);
	}

}
