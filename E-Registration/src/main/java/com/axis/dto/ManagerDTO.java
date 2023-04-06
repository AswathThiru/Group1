package com.axis.dto;

public class ManagerDTO {

	private int id;
	private String empId;
	private String branch;
	private String emailId;
	private String designation;
	private String region;
	private String cluster;
	private String branchName;
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public ManagerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerDTO(int id, String empId, String branch, String emailId, String designation, String region,
			String cluster, String branchName,String name) {
		super();
		this.id = id;
		this.empId = empId;
		this.branch = branch;
		this.emailId = emailId;
		this.designation = designation;
		this.region = region;
		this.cluster = cluster;
		this.branchName = branchName;
		this.name=name;
	}
	
	
}



