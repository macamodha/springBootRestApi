package com.chulan.springBootRestApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chulan.springBootRestApi.model.Employee;
import com.chulan.springBootRestApi.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	//to save an employee
	@PostMapping("/save")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	//get all the employees
	@GetMapping("/list")
	public List<Employee> getAll() {
		return employeeService.findAll();
	}
	
	//get employee by a particular id
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(value="id") Long empid) {
		
		Employee emp = employeeService.findOne(empid);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	// update an employee
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee employee) {
		
		Employee emp = employeeService.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setFname(employee.getFname());
		emp.setlName(employee.getlName());
		emp.setDivision(employee.getDivision());
		
		employeeService.save(emp);
		return ResponseEntity.ok().body(emp);
	}
	
	//Delete an Employee
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid) {
		
		Employee emp = employeeService.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeService.deleteEmp(emp);
		return ResponseEntity.ok().build();
	}
	
}
