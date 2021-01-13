package com.example.InsurancePolicyManagement.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "employeee", indexes = {
		@Index(name = "config_index",columnList = "empid,firstname,middlename,lastname,address,contactno", unique = true) })
public class Configuration {
	@Id
	@GeneratedValue
	@Column(name = "empid", updatable = false, nullable = false, unique = true)
	private Long empid;
	
	@Column(name = "firstname",nullable = false)
	private String firstname;

	@Column(name = "middlename", nullable = false)
	private String middlename;

	@Column(name = "lastname", nullable = true)
	private String lastname;
	
	@Column(name = "address", nullable = true)
	private String address;

	@Column(name = "contactno", nullable = true)
	private String contactno;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	
	
	

	
}
