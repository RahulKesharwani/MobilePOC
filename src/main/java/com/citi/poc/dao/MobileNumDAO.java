package com.citi.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.poc.model.MobileNumberData;

public interface MobileNumDAO extends JpaRepository< MobileNumberData, String>{

	MobileNumberData findMobileDetailsByMobileNumber(String mobileNumber);
}
