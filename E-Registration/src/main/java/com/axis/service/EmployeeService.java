package com.axis.service;

import java.util.List;

import com.axis.dto.EmployeeDTO;
import com.axis.entity.Employee;


public interface EmployeeService {
	
	Employee addEmployee(Employee emp);
	 List<Employee> getList();
	 String deleteEmployee(int id);
	 Employee updateEmployee(Employee emp,int id);
	 Employee findById(int eid);
	

}
