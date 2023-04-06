package com.axis.serviceImpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.ApprovalTable;
import com.axis.entity.Manager;
import com.axis.exception.IdNotFoundException;
import com.axis.repository.ApprovalTableRepository;
import com.axis.repository.managerRepository;
import com.axis.service.managerInterface;
@Service
public class managerImpl implements managerInterface {

	@Autowired
	ApprovalTableRepository approvalTableRepository;
	
	@Autowired
	managerRepository managerRepo;
	@Override
	
	public Manager addManager(Manager manager) {
	return	managerRepo.save(manager);
		
	}

	@Override
	public List<Manager> getList() {
		// TODO Auto-generated method stub
		return managerRepo.findAll();
	}

	@Override
	public String deleteManager(int id) {
		Optional<Manager> managerObj=managerRepo.findById(id);
		if(managerObj.isPresent()) {
			managerRepo.deleteById(id);;
			return "Manager Deleted Succesfully";
		}
		else {
			throw new IdNotFoundException("No Id present to delete");
		}
		
	}

	@Override
	public Manager updatemanager(Manager manager, int id) {
		Optional<Manager> managerObj= managerRepo.findById(id);
		if(managerObj.isPresent()) {
			return managerRepo.save(manager);
		}else {
			throw new IdNotFoundException("No Id present to update");
		}
		
	}
	@Override
	public Manager findById(int id) {
		
		Optional<Manager> emp = managerRepo.findById(id);
		
		if(emp.isPresent())
			return emp.get();
		else
			throw new IdNotFoundException("No Id present to get the value"); 
	
	
	
}

	@Override
	public ApprovalTable saveApprovalData(ApprovalTable approvalTable) {
		// TODO Auto-generated method stub
		return approvalTableRepository.save(approvalTable);
	}
}