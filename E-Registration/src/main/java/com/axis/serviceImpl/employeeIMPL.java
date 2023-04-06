package com.axis.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.Employee;
import com.axis.entity.Manager;
import com.axis.exception.IdNotFoundException;
import com.axis.repository.employeeRepository;
import com.axis.repository.managerRepository;
import com.axis.service.EmployeeService;

@Service
public class employeeIMPL implements EmployeeService {

	@Autowired 
	employeeRepository employeeRep;
	@Autowired
	managerRepository managerRepo;

	@Override
	public Employee addEmployee(Employee emp) {
		
	
		
		return employeeRep.save(emp);
	}

	@Override
	public List<Employee> getList() {
		// TODO Auto-generated method stub
		return employeeRep.findAll();
	}

	@Override
	public String deleteEmployee(int id) {
		Optional<Employee> empObj=employeeRep.findById(id);
		if(empObj.isPresent()) {
			employeeRep.deleteById(id);;
			return "Manager Deleted Succesfully";
		}
		else {
			throw new IdNotFoundException("No Id present to delete");
		}
		
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) {
		Optional<Employee> managerObj= employeeRep.findById(id);
		if(managerObj.isPresent()) {
			return employeeRep.save(emp);
		}else {
			throw new IdNotFoundException("No Id present to update");
		}
		
	}

	@Override
	public Employee findById(int eid) {
	Optional<Employee> emp = employeeRep.findById(eid);
		
		if(emp.isPresent())
			return emp.get();
		else
			throw new IdNotFoundException("No Id present to get the value"); 
	
	
	
}

}
