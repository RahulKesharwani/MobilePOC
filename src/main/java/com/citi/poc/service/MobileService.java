package com.citi.poc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.citi.poc.dao.MobileNumDAO;
import com.citi.poc.model.MobileNumberData;

@Service
@Repository
public class MobileService {

	@Autowired
	private MobileNumDAO mobileNumDAO;
	public boolean checkMobileNumber(String mobileNumber){
		MobileNumberData mobileData = mobileNumDAO.findMobileDetailsByMobileNumber(mobileNumber);
		if(mobileData != null && mobileData.getMobileNumber() != null){
		System.out.println("Fetched Data: " + mobileData.getMobileNumber());
			return true;
		}
		return false;
	}
	
	public void addMobileNum(String string) {
		MobileNumberData data = new MobileNumberData();
		data.setMobileNumber(string);
		mobileNumDAO.saveAndFlush(data);
	}
	
	
	
}
