package com.citi.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citi.poc.model.MobileNumberData;
import com.citi.poc.model.Offers;
import com.citi.poc.service.MobileService;

@Controller
public class MainController {

	@Autowired
	private MobileService mobileService;
	
	@RequestMapping("/")
	public @ResponseBody String sayIndex(){
		return "Welcome to Mobile Number Page";
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value="saveMobileNumber")
	public String addMobileNumDeatails(Model model,MobileNumberData mobileNumberData){
		System.out.println(" data1: " + mobileNumberData.getMobileNumber());
		System.out.println(" data2: " + mobileNumberData.getFirstName());
		mobileService.addMobileNumData(mobileNumberData);
		model.addAttribute("message" , "Data is successfully Added");
		model.addAttribute("mobileNumModel", new MobileNumberData());
		return "MobileNum";
	}
	
	
	
	@RequestMapping("checkMobileNumber")
	public String checkMobileNumGet(Model model){
		model.addAttribute("mobileNumModel", new MobileNumberData());
		return "MobileNum";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="checkMobileNumber")
	public String checkMobileNumPost(Model model, MobileNumberData mobileNumberData){
		String mobileNumber = mobileNumberData.getMobileNumber();
		System.out.println("Entered data: " + mobileNumber);
		String targetPage = mobileService.checkMobileNumber(mobileNumber)?"Recharge":"Registration";
		if("Recharge".equals(targetPage)){
			mobileNumberData =  mobileService.retrieveUserData(mobileNumber);
			Offers offers = new Offers();
			offers.setMobileNumber(mobileNumberData.getMobileNumber());
			offers.setOfferAmount(10L);
			model.addAttribute("offers", offers);
		}
		model.addAttribute("mobileNumModel", mobileNumberData);
		return targetPage;
	}
	
	@RequestMapping("/AddDummyOffers")
	public @ResponseBody String dummyOffers(){
		Offers offers = new Offers();
		offers.setMobileNumber("123456789");
		offers.setOfferAmount(50L);
		return "Offers are added";
	}
}
