package com.infostretch.poc.springbootmaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infostretch.poc.springbootmaven.dao.Employee;
import com.infostretch.poc.springbootmaven.services.DataNotFoundException;
import com.infostretch.poc.springbootmaven.services.EmployeeServiceImp;

//Create Rest API 
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImp service;
	
	//Controller will fetch all employee details from Service class  and return in json format 
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee>list = service.getAllEmployees();
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(list,new HttpHeaders(),HttpStatus.OK);
		return response;
	}
	
	
	//Particular employee details will be shown it accept id of particular employee 
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws DataNotFoundException{
		Employee detail = service.getEmployeeById(id);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(detail,new HttpHeaders(),HttpStatus.OK);
		return response;
	}
	
	//Updating particular employee and creating new employee
	@PostMapping("/add")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws DataNotFoundException{
		Employee updateEmployee = service.createEmployee(employee);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(updateEmployee,new HttpHeaders(),HttpStatus.OK);
		System.out.println(response);
		return response;
	}
	
	//Update the Existing Employee
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws DataNotFoundException{
		Employee updateEmployee = service.updateEmployee(employee);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(updateEmployee,new HttpHeaders(),HttpStatus.OK);
		System.out.println(response);
		return response;
	}
	
	
	//Delete particular Employee by accepting id 
	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws DataNotFoundException{
		service.deleteEmployee(id);
		return HttpStatus.MOVED_PERMANENTLY;
	}
	
}
