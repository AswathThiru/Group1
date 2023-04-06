package com.axis.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.dto.pdfDTO;
import com.axis.entity.CreateId;
import com.axis.entity.PdfFile;
import com.axis.repository.CreateIdRepo;
import com.axis.repository.PdfFileRepository;
import com.axis.repository.employeeRepository;

@Service
public class PdfFileService {
	static final String BaseId="BBO/43/BDR";
    @Autowired
    private PdfFileRepository pdfFileRepository;
    @Autowired
    private employeeRepository employeeRepository;
    
    @Autowired
    private CreateIdRepo createIdRepo;
    
    public void savePdfFile(MultipartFile file, LocalDate expiryDate,LocalDate startDate,String userEmail,int empId,String  bdrType, String description) throws Exception {
        CreateId createId=new CreateId();
        createIdRepo.save(createId);
        
        CreateId obj  =  createIdRepo.findFirstByOrderByIdDesc();
        PdfFile finalLastObj= new PdfFile();
        finalLastObj.setPid((long) obj.getId());
        finalLastObj.setName(file.getName());
        //pdfFile.setType(file.getContentType());
        finalLastObj.setUploadedBy("User"); // Replace with actual user
        finalLastObj.setUploadedDate(LocalDate.now());
        finalLastObj.setStartDate(startDate);
        finalLastObj.setUserEmail(userEmail);
        finalLastObj.setEmpId(empId);
        if (expiryDate != null) {
        	finalLastObj.setExpiryDate(expiryDate);
        }
        finalLastObj.setData(file.getBytes());
        finalLastObj.setBdrType(bdrType);
        finalLastObj.setEmployee(employeeRepository.findByEid(empId));
        finalLastObj.setDescription(description);
        String srno=BaseId+"/"+empId+"/"+(long) obj.getId();
        finalLastObj.setSrNo(srno);
        pdfFileRepository.save(finalLastObj);
//        List<PdfFile> fileList =pdfFileRepository.findAll();
//        if()
//        pdfFileRepository.findById(null)
//        
//        List<PdfFile> fileList =pdfFileRepository.findAll();
//        for(PdfFile fileobj: fileList) {
//        	PdfFile finalListObj= new PdfFile();
//        	String srno=BaseId+"/"+fileobj.getEmpId()+"/"+fileobj.getPid();
//        	finalListObj.setSrNo(srno);
//        	pdfFileRepository.u(finalListObj);
//        }
    }
    
    public PdfFile getPdfFileById(Long id) throws Exception {
        Optional<PdfFile> optionalPdfFile = pdfFileRepository.findById(id);
        if (optionalPdfFile.isPresent()) {
            return optionalPdfFile.get();
        } else {
            throw new Exception("PDF file not found.");
        }
    }

	public PdfFile getSrNo(String srNo) {
		
		PdfFile file=	pdfFileRepository.findBySrNo(srNo);
		return file;
	}
	public List<PdfFile> getAllPdfFiles() {
	
        return pdfFileRepository.findAll();
    }
	
    public List<PdfFile> getSortedFiles(){
    	List<PdfFile> list =pdfFileRepository.findAll();
    	List< PdfFile> sortedList= new ArrayList<>();
    	//List< PdfFile> = new ArrayList<>();
    	
    	for(PdfFile obj:list) {
    		
    		if(obj.getEmployee().getBranch().equals(obj.getEmployee().getManager().getBranch())) {
    			PdfFile objfinal=new PdfFile();
    			objfinal.setPid(obj.getPid());
    			objfinal.setBdrType(obj.getBdrType());
    			objfinal.setData(obj.getData());
    			objfinal.setDescription(obj.getDescription());
    			objfinal.setEmpId(obj.getEmpId());
    			objfinal.setExpiryDate(obj.getExpiryDate());
    			objfinal.setName(obj.getName());
    			objfinal.setSrNo(obj.getSrNo());
    			objfinal.setStartDate(obj.getStartDate());
    			objfinal.setUploadedBy(obj.getUploadedBy());
    			objfinal.setUploadedDate(obj.getUploadedDate());
    			objfinal.setUserEmail(obj.getUserEmail());
    			objfinal.setEmployee(obj.getEmployee());
   
    			sortedList.add(objfinal);
    			}else {
    				continue;
    			}
    	}
		return sortedList;
    	
    	}
	
    
}
