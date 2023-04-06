package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.ApprovalTable;
import com.axis.entity.PdfFile;
import com.axis.repository.ApprovalTableRepository;

@Service
public class ApprovedFileService {

	@Autowired
	private ApprovalTableRepository approvalTableRepository;
	
	
	public List<ApprovalTable> getAllApprovedFiles() {
        return approvalTableRepository.findAll();
    }
}
