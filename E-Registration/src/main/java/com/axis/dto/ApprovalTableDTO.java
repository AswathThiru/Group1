package com.axis.dto;

import java.time.LocalDate;

public class ApprovalTableDTO {

	private int id;
	private String srNo;
	private LocalDate startDate; 
    private LocalDate expiryDate;
    private String region;
    private String circel;
    private String cluster;
    private String branch;
    
	public ApprovalTableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovalTableDTO(int id, String srNo, LocalDate startDate, LocalDate expiryDate, String region, String circel,
			String cluster, String branch) {
		super();
		this.id = id;
		this.srNo = srNo;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.region = region;
		this.circel = circel;
		this.cluster = cluster;
		this.branch = branch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCircel() {
		return circel;
	}

	public void setCircel(String circel) {
		this.circel = circel;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
    
	
    
}
