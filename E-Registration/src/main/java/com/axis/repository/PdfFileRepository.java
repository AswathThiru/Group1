package com.axis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.entity.PdfFile;

public interface PdfFileRepository extends JpaRepository<PdfFile, Long> {
//	
//	 Optional<PdfFile> findByIdAndExpiryDateAfter(Long id, String expiryDate);
//
//	    void deleteByIdAndExpiryDateBefore(Long id, String expiryDate);
	public PdfFile findByPid(long id);
	public PdfFile findBySrNo(String srNo);
	public PdfFile findFirstByOrderByPidDesc();
}