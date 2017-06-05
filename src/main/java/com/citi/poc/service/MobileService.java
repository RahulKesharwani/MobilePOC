package com.citi.poc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.citi.poc.dao.BillingDAO;
import com.citi.poc.dao.MobileNumDAO;
import com.citi.poc.dao.OffersDAO;
import com.citi.poc.model.BillingDetails;
import com.citi.poc.model.MobileNumberData;
import com.citi.poc.model.Offers;

@Service
@Repository
public class MobileService {

	@Autowired
	private MobileNumDAO mobileNumDAO;
	@Autowired
	private OffersDAO offersDAO;
	@Autowired
	private BillingDAO billingDAO;
	
	public boolean checkMobileNumber(String mobileNumber){
		MobileNumberData mobileData = retrieveUserData(mobileNumber);
		if(mobileData != null && mobileData.getMobileNumber() != null){
		System.out.println("Fetched Data: " + mobileData.getMobileNumber());
			return true;
		}
		return false;
	}
	
	public void addMobileNumData(MobileNumberData data) {
		mobileNumDAO.save(data);
	}
	
	public MobileNumberData retrieveUserData(String mobileNumber){
		return mobileNumDAO.findMobileDetailsByMobileNumber(mobileNumber);
	}
	
	public Offers retrieveOffers(String mobileNumber){
		return offersDAO.findOffersByMobileNumber(mobileNumber);
	}
	
	public void updateTotalCreditedAmout(String mobileNum, Long totalAmout){
		BillingDetails billingDetails = billingDAO.findBillingDetailsByMobileNumber(mobileNum);
		if( billingDetails != null ){
			totalAmout += billingDetails.getTotalCredited();
			billingDetails.setTotalCredited(totalAmout);
		}else{		
			billingDetails = new BillingDetails();
			billingDetails.setMobileNumber(mobileNum);
			billingDetails.setTotalCredited(totalAmout);
		}
		billingDAO.save(billingDetails);
	}
}