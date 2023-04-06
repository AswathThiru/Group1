package com.axis.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String empId;
	private String branch;
	private String emailId;
	private String designation;
	private String region;
	private String cluster;
	private String branchName;
	private String name;
	//private String managerempId;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Manager.class)
	  private Manager manager;

	
		/*
		 * @OneToMany(cascade = CascadeType.ALL, targetEntity = PdfFile.class)
		 * 
		 * @JoinColumn(name = "fileid") List <PdfFile> file = new ArrayList<>();
		 */
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String empId, String branch, String emailId, String designation, String region,
			String cluster, String branchName, String name, Manager manager) {
		super();
		this.eid = eid;
		this.empId = empId;
		this.branch = branch;
		this.emailId = emailId;
		this.designation = designation;
		this.region = region;
		this.cluster = cluster;
		this.branchName = branchName;
		this.name = name;
		this.manager = manager;
		
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
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
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
	
}