package com.axis.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.entity.Employee;

public interface employeeRepository extends JpaRepository<Employee, Integer>{
	
	public Employee findByName(String name);
	
	public Employee findByEid(int eid );
}
