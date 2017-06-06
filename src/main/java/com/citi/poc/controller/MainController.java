package com.citi.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			model.addAttribute("mobileNum", mobileNumberData.getMobileNumber());
		}
		model.addAttribute("mobileNumModel", mobileNumberData);
		return targetPage;
	}
	
	@RequestMapping("/AddOffers")
	public String addOffers(){
		return "AddOffers";
	}
	
	@RequestMapping(value="/AddOffers", method=RequestMethod.POST )
	public String addPostOffers(@RequestParam("offerAmt") String offerAmount, @RequestParam("mobileNum") String mobileNum){
		Offers offers = new Offers();
		offers.setMobileNumber(mobileNum);
		offers.setOfferAmount(Long.parseLong(offerAmount));
		mobileService.saveOffers(offers);
		return "AddOffers";
	}
	
	@RequestMapping(value="/totalCredited", method=RequestMethod.POST )
	public String addPostOffers(@RequestParam("mobileNum") String mobileNum, Model model){
		Long totalAmt = mobileService.retrieveTotalCreditedAmount(mobileNum);
		if(totalAmt == -1L){
			model.addAttribute("totalAmt", "There is no credited amount");
		}else{
			model.addAttribute("totalAmt", totalAmt);
		}
		model.addAttribute("mobileNum", mobileNum);
		return "Recharge";
	}
	
	@RequestMapping(value="/RechargeMobileNum", method=RequestMethod.POST)
	public String rechargeMobileNumber(Model model, @RequestParam("rechargeAmt") String rechargeAmt, @RequestParam("mobileNum") String mobileNum){
		if(StringUtils.isEmpty(rechargeAmt)){
			model.addAttribute("errorAmountMsg", "Please enter some amount");
			model.addAttribute(mobileNum);
			return "Recharge";
		}
		System.out.println(rechargeAmt);
		Long rechargeAmount = Long.parseLong(rechargeAmt);
		
		Offers offers = mobileService.retrieveOffers(mobileNum);
		if(offers!=null){
			
			rechargeAmount = rechargeAmount+offers.getOfferAmount();
			
		}
		else{
		rechargeAmount=rechargeAmount-2;
		}
		mobileService.updateTotalCreditedAmout(mobileNum, rechargeAmount);
		model.addAttribute(mobileNum);
		return "SuccessRecharge";
	}
	
}
