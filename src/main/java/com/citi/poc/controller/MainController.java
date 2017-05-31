package com.citi.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citi.poc.model.MobileNumberData;
import com.citi.poc.service.MobileService;

@Controller
public class MainController {

	@Autowired
	private MobileService mobileService;
	
	@RequestMapping("/")
	public @ResponseBody String sayIndex(){
		return "Welcome to Mobile Number Page";
	}
	
	@RequestMapping("/AddDummyData")
	public @ResponseBody String addMobileNum(){
		mobileService.addMobileNum("123456789");
		return "Data is added";
	}
	
	@RequestMapping("checkMobileNumber")
	public String checkMobileNumGet(Model model){
		model.addAttribute("mobileNumModel", new MobileNumberData());
		return "MobileNum";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="checkMobileNumber")
	public String checkMobileNumPost(Model model, MobileNumberData mobileNumberData){
		System.out.println("Entered data: " + mobileNumberData.getMobileNumber());
		return mobileService.checkMobileNumber(mobileNumberData.getMobileNumber())?"Recharge":"Registration";
	}
}
