package com.axis.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axis.entity.PdfFile;
import com.axis.repository.PdfFileRepository;
import com.axis.repository.employeeRepository;
import com.axis.service.PdfFileService;

@CrossOrigin
@RestController
@RequestMapping("/api/pdf")
public class PdfController {
    
	@Autowired
	employeeRepository emprepo;
    @Autowired
    private PdfFileService pdfFileService;
    @Autowired
    PdfFileRepository pdfFileRepository;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadPdfFile(@RequestParam("file") MultipartFile file,
                                                @RequestParam(name = "expiryDate", required = false)
                                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate expiryDate,
                                                @RequestParam(name="startDate",required=true)
    											@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate startDate ,
    											@RequestParam(name="userEmail",required = true)
    											String userEmail,
    											@RequestParam("empId") int empId ,
    											@RequestParam("bdrType") String bdrType,
    											@RequestParam("description") String description)
    											
    {
        try {
            //pdfFileService.savePdfFile(file, expiryDate);
            pdfFileService.savePdfFile(file, expiryDate,startDate,userEmail,empId,bdrType,description);
        	return ResponseEntity.ok("File uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        try {
            PdfFile pdfFile = pdfFileService.getPdfFileById(id);
            HttpHeaders headers = new HttpHeaders();
           // headers.setContentType(MediaType.parseMediaType(pdfFile.getType()));
            headers.setContentDispositionFormData(pdfFile.getName(), pdfFile.getName());
            return new ResponseEntity<byte[]>(pdfFile.getData(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePdfFile(@PathVariable Long id) {
        try {
            Optional<PdfFile> pdfFileOptional = pdfFileRepository.findById(id);
            if (pdfFileOptional.isPresent()) {
                PdfFile pdfFile = pdfFileOptional.get();
                pdfFileRepository.delete(pdfFile);
                return ResponseEntity.ok("File deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting file.");
        }
    }

}
