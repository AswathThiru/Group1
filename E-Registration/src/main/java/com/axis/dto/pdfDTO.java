package com.axis.dto;

import java.time.LocalDate;

import com.axis.entity.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class pdfDTO {    
	 private Long pid;
	    private String srNo;
	    private String name;
	    
	    @Lob
	    @Column(columnDefinition="MEDIUMBLOB")
	    private byte[] data;
	    
	    
	    private String uploadedBy;
	    
	   
	    private LocalDate uploadedDate;
	    
	    private LocalDate startDate;
	    
	    private LocalDate expiryDate;
	    
	    private String userEmail;
	    
	  private String status;
	  private int empId;
	  private String bdrType;
	  private String description;
	  private Employee employee;
	    
	//  @ManyToOne(cascade = CascadeType.ALL)
	//  private Employee employee;




	public pdfDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public pdfDTO(Long pid, String srNo, String name, byte[] data, String uploadedBy, LocalDate uploadedDate,
			LocalDate startDate, LocalDate expiryDate, String userEmail, String status, int empId, String bdrType,
			String description, Employee employee) {
		super();
		this.pid = pid;
		this.srNo = srNo;
		this.name = name;
		this.data = data;
		this.uploadedBy = uploadedBy;
		this.uploadedDate = uploadedDate;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.userEmail = userEmail;
		this.status = status;
		this.empId = empId;
		this.bdrType = bdrType;
		this.description = description;
		this.employee = employee;
	}



	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public LocalDate getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(LocalDate uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getBdrType() {
		return bdrType;
	}

	public void setBdrType(String bdrType) {
		this.bdrType = bdrType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	
}
