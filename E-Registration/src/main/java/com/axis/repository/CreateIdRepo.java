package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.entity.CreateId;
import com.axis.entity.PdfFile;

public interface CreateIdRepo extends JpaRepository<CreateId, Integer> {
 public CreateId findFirstByOrderByIdDesc();
}
