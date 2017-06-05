package com.citi.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Offers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="OFFER_AMT")
	private Long offerAmount;
	
	@Column(name="TOTAL_CREDITED")
	private Long totalCredited;
	
	@Column(name="MOB_NUM")
	private String mobileNumber;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(Long offerAmount) {
		this.offerAmount = offerAmount;
	}

	public Long getTotalCredited() {
		return totalCredited;
	}

	public void setTotalCredited(Long totalCredited) {
		this.totalCredited = totalCredited;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
