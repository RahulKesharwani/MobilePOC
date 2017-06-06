package com.citi.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.poc.model.Offers;

public interface OffersDAO extends JpaRepository<Offers, Integer> {

	public Offers findOffersByMobileNumber(String mobileNumber);
	
	
}
