package com.chulan.springBootRestApi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotBlank;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="employee")
//@EntityListeners(AuditingEntityListener.class)

public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String fname;
	
	@NotBlank
	private String lName;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="div_id")
	private Division division;

	
	//getters and setter goes here
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}
	
	
	
	
}
