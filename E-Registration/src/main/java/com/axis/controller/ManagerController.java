package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.ApprovalTableDTO;
import com.axis.dto.pdfDTO;
import com.axis.entity.ApprovalTable;
import com.axis.entity.Manager;
import com.axis.entity.PdfFile;
import com.axis.exception.IdNotFoundException;
import com.axis.service.ApprovedFileService;
import com.axis.service.PdfFileService;
import com.axis.service.managerInterface;

@CrossOrigin
@RestController
@RequestMapping("/api/manager")
public class ManagerController {

	@Autowired
	private ApprovedFileService approvedFileService;

	  @Autowired
	    private PdfFileService pdfFileService;
	@Autowired
	managerInterface managerInt;
	
	@PostMapping("/addManager")
	ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
		
        return new ResponseEntity<Manager>(managerInt.addManager(manager), HttpStatus.OK);

}
	@GetMapping("/managers")
    ResponseEntity<List<Manager>> getList() {
        return new ResponseEntity<List<Manager>>(managerInt.getList(), HttpStatus.OK); 
     }
	
	@GetMapping("/manager/{id}")
    ResponseEntity<Manager>findById(@PathVariable int id){
		Manager manager	= managerInt.findById(id);
    	 return new ResponseEntity<Manager>(manager,HttpStatus.OK);
}
	@PutMapping("/manager/{id}")
    ResponseEntity<Manager> updatemanager(@PathVariable int id,@RequestBody Manager manager){
        return new ResponseEntity<Manager>(managerInt.updatemanager(manager, id), HttpStatus.OK);
    }

    @ExceptionHandler(IdNotFoundException.class)
    ResponseEntity<String> myException(IdNotFoundException exception){
    	return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/manager/{id}")
    ResponseEntity<String> deleteManager(@PathVariable int id){
    	return new ResponseEntity<String>(managerInt.deleteManager(id), HttpStatus.OK);
    }
    @PostMapping("/ApproveFile")
    public ResponseEntity<ApprovalTable> addApprovalFiles(@RequestBody ApprovalTableDTO approvalTableDTO){
    	ApprovalTable objApproval = new ApprovalTable();
    	
    	objApproval.setSrNo(approvalTableDTO.getSrNo());
    	objApproval.setBranch(approvalTableDTO.getBranch());
    	objApproval.setCircel(approvalTableDTO.getCircel());
    	objApproval.setCluster(approvalTableDTO.getCluster());
    	objApproval.setExpiryDate(approvalTableDTO.getExpiryDate());
    	objApproval.setRegion(approvalTableDTO.getRegion());
    	objApproval.setStartDate(approvalTableDTO.getStartDate());
    	managerInt.saveApprovalData(objApproval);
		return new ResponseEntity("Successs Approved File",HttpStatus.OK);
    	
    }
    @PostMapping("/getBySrno")
    public ResponseEntity<PdfFile> getBySrno(@RequestParam("srNo") String srNo){
    	System.out.println("/heeloooo");
    	PdfFile file=pdfFileService.getSrNo( srNo);
    	return  new ResponseEntity<PdfFile>(file, HttpStatus.OK);
    }
    
//    @GetMapping("/allPdf")
//    public ResponseEntity<List<PdfFile>> getAllPdfFiles() {
//        try {
//            List<PdfFile> pdfFiles = pdfFileService.getAllPdfFiles();
//            return ResponseEntity.ok().body(pdfFiles);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
    @GetMapping("/allPdf")
    public ResponseEntity<List<PdfFile>> getSortedFiles(){
    	try {
    		System.out.println("HIIIIIIIIIIIIIIIIII");
    		List<PdfFile> sortedList=pdfFileService.getSortedFiles();
    		return ResponseEntity.ok().body(sortedList);
    	}catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
     }
    }
    @GetMapping("/allApproved")
    public ResponseEntity<List<ApprovalTable>> getAllApprovedFiles(){
    	try {
    		List<ApprovalTable> approvalTables = approvedFileService.getAllApprovedFiles();
    		return ResponseEntity.ok().body(approvalTables);
    	}  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

