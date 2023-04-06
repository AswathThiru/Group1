package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.entity.ApprovalTable;

public interface ApprovalTableRepository extends JpaRepository<ApprovalTable, Integer> {

}
