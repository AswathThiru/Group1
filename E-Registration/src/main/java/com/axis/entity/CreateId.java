package com.axis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="create_id")
public class CreateId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public CreateId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateId(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    
    
}
