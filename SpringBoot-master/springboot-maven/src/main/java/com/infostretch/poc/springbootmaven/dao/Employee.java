package com.infostretch.poc.springbootmaven.dao;
import javax.persistence.*;

//Entity Class which represents entity details which are present in databases.

@Entity
@Table(name="employee_details")
public class Employee {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="empId")
	private String empId;
	
	@Column(name="department")
	private String department;

	
	
	//A Set of Getter and Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	//To String
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empId=" + empId + ", department=" + department + "]";
	}
	
}
