package com.infostretch.poc.springbootmaven.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infostretch.poc.springbootmaven.dao.Employee;
import com.infostretch.poc.springbootmaven.dao.EmployeeRepo;

//Service Components Class, it's a bussiness logic layer 

@Service
public class EmployeeServiceImp implements EmployeeService {

	// implecitly inject object dependency like setters and constructors
	@Autowired
	EmployeeRepo dataStorage;

	// return the list of all employee
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = dataStorage.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<Employee>();
		}
	}

	// return the particular employee according to id
	public Employee getEmployeeById(Long id) throws DataNotFoundException {
		// Optional handel null checks
		Optional<Employee> employee = dataStorage.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new DataNotFoundException("id is invalid: " + id);
		}
	}

	// create new employee details or update the respective employee details
	public Employee createEmployee(Employee details) {
		if (details.getId() == null) {
			details = dataStorage.save(details);
			return details;
		}
		return null;
	}

	// delete particular employee
	public void deleteEmployee(Long id) throws DataNotFoundException {
		Optional<Employee> employee = dataStorage.findById(id);
		if (employee.isPresent()) {
			dataStorage.deleteById(id);
		} else {
			throw new DataNotFoundException("invalid id: " + id);
		}
	}

	
	//updating Existing Employee and saving in database
	@Override
	public Employee updateEmployee(Employee details) throws DataNotFoundException {
		Optional<Employee>employee = dataStorage.findById(details.getId());
		if(employee.isPresent()) {
			Employee newDetails = employee.get();
			newDetails.setName(details.getName());
			newDetails.setEmpId(details.getEmpId());
			newDetails.setDepartment(details.getDepartment());
			
			newDetails = dataStorage.save(newDetails);
			return newDetails;
		}
		return null;
	}

}
