package com.citi.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.poc.model.BillingDetails;

public interface BillingDAO extends JpaRepository<BillingDetails, Integer>{

	public BillingDetails findBillingDetailsByMobileNumber(String mobileNumber);
	
}
