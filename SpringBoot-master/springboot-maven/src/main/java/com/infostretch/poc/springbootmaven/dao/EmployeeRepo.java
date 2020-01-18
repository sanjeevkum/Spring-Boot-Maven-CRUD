package com.infostretch.poc.springbootmaven.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//provides all crud opertion and create repository implementation implicitly at runtime

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}	
