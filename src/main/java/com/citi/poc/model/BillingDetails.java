package com.citi.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class BillingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long billingId;
	
	@Column(name="MOB_NUM", unique=true)
	private String mobileNumber;
	
	@Column(name="TOTAL_CREDIT")
	private Long totalCredited;

	public Long getBillingId() {
		return billingId;
	}

	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getTotalCredited() {
		return totalCredited;
	}

	public void setTotalCredited(Long totalCredited) {
		this.totalCredited = totalCredited;
	}
	
	
}
