package com.infostretch.poc.springbootmaven.services;

import java.util.List;

import com.infostretch.poc.springbootmaven.dao.Employee;

public interface EmployeeService {
	//Get List of all Employee
	List<Employee> getAllEmployees();
	//Get Particular Employee via id
	Employee getEmployeeById(Long id) throws DataNotFoundException;
	//Create New Employee Details
	Employee createEmployee(Employee details);
	//Delete particular employee via taking id
	void deleteEmployee(Long id) throws DataNotFoundException;
	//Update Existing Employee Details
	Employee updateEmployee(Employee empoyee) throws DataNotFoundException;
}
