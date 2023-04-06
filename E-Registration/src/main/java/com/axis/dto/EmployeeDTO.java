package com.axis.dto;

import java.util.ArrayList;
import java.util.List;

import com.axis.entity.Manager;
import com.axis.entity.PdfFile;

public class EmployeeDTO {
	
	private int id;
	private String empId;
	private String branch;
	private String emailId;
	private String designation;
	private String region;
	private String cluster;
	private String branchName;
	private String name;
	private int managerId;
	private  PdfFile pfile;
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDTO(int id, String empId, String branch, String emailId, String designation, String region,
			String cluster, String branchName, String name, int managerId, PdfFile pfile) {
		super();
		this.id = id;
		this.empId = empId;
		this.branch = branch;
		this.emailId = emailId;
		this.designation = designation;
		this.region = region;
		this.cluster = cluster;
		this.branchName = branchName;
		this.name = name;
		this.managerId = managerId;
		this.pfile = pfile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public PdfFile getPfile() {
		return pfile;
	}
	public void setPfile(PdfFile pfile) {
		this.pfile = pfile;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	
	

	
}
