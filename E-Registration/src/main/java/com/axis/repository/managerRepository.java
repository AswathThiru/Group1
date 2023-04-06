package com.axis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.entity.Manager;

public interface managerRepository extends JpaRepository<Manager, Integer>{
	//public Optional<Manager> findById(int id);

	public Manager findByName(String name);
	
	public Manager findByMid(int mid);
}
