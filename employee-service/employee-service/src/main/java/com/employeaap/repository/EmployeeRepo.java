package com.employeaap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeaap.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
}
