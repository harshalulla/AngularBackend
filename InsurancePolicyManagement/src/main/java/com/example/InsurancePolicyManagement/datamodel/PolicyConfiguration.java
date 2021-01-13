package com.example.InsurancePolicyManagement.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "policies", indexes = {
		@Index(name = "config_index",columnList = "id,policynumber,amount", unique = true) })
public class PolicyConfiguration {
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private Long id;
	
	@Column(name = "policynumber",nullable = false)
	private String policynumber;

	@Column(name = "amount", nullable = false)
	private String amount;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
