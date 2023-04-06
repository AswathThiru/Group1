package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.EmployeeDTO;
import com.axis.entity.Employee;
import com.axis.entity.Manager;
import com.axis.exception.IdNotFoundException;
import com.axis.repository.PdfFileRepository;
import com.axis.repository.managerRepository;
import com.axis.serviceImpl.employeeIMPL;

@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	managerRepository managerRepo;
	@Autowired
	employeeIMPL emp;
	
	@Autowired
	PdfFileRepository fileRepo;
	
	@PostMapping("/addEmployee")
	ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		
		Employee emp1=new Employee();
		
		emp1.setBranch(employeeDTO.getBranch());
		emp1.setEmailId(employeeDTO.getEmailId());
		emp1.setDesignation(employeeDTO.getDesignation());
		emp1.setRegion(employeeDTO.getRegion());
		emp1.setCluster(employeeDTO.getCluster());
		emp1.setBranchName(employeeDTO.getBranchName());
		emp1.setName(employeeDTO.getName());
		emp1.setEmpId(employeeDTO.getEmpId());
//		Manager manager = managerRepo.findByEmpId(employeeDTO.getManagerempId());
		emp1.setManager(managerRepo.findByMid(employeeDTO.getManagerId()));
//		emp1.setManagerempId(employeeDTO.getManagerempId());
		
		
	emp.addEmployee(emp1);
		
        return new ResponseEntity("Success", HttpStatus.OK);

}
	@GetMapping("/Employees")
    ResponseEntity<List<Employee>> getList() {
        return new ResponseEntity<List<Employee>>(emp.getList(), HttpStatus.OK); 
     }
	
	@GetMapping("/employee/{eid}")
    ResponseEntity<Employee>findById(@PathVariable int eid){
		Employee employee	= emp.findById(eid);
    	 return new ResponseEntity<Employee>(employee,HttpStatus.OK);
}
	@PutMapping("/employee/{id}")
    ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee ){
        return new ResponseEntity<Employee>(emp.updateEmployee(employee, id), HttpStatus.OK);
    }

    @ExceptionHandler(IdNotFoundException.class)
    ResponseEntity<String> myException(IdNotFoundException exception){
    	return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/employee/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable int id){
    	return new ResponseEntity<String>(emp.deleteEmployee(id), HttpStatus.OK);
    }
}
