package com.axis.service;


import java.util.List;

import com.axis.entity.ApprovalTable;
import com.axis.entity.Manager;

public interface managerInterface {
	
	 Manager addManager(Manager manager);
	 List<Manager> getList();
	 String deleteManager(int id);
	 Manager updatemanager(Manager manager,int id);
	Manager findById(int id);
	
	public ApprovalTable saveApprovalData (ApprovalTable approvalTable);

}

