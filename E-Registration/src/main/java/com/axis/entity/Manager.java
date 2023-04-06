package com.axis.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Manager_Details")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String empId;
	private String branch;
	private String emailId;
	private String designation;
	private String region;
	private String cluster;
	private String branchName;
	private String name;
	
//	@OneToMany( mappedBy = "manager", targetEntity = Employee.class)
//	private List<Employee> employee;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int mid, String empId, String branch, String emailId, String designation, String region,
			String cluster, String branchName, String name) {
		super();
		this.mid = mid;
		this.empId = empId;
		this.branch = branch;
		this.emailId = emailId;
		this.designation = designation;
		this.region = region;
		this.cluster = cluster;
		this.branchName = branchName;
		this.name = name;
	
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Employee> getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(List<Employee> employee) {
//		this.employee = employee;
//	}

	

	
	
}

