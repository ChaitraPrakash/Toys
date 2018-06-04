package com.niit.ToysBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Billing {
	@Id
	private String billingId;
	private String billingName;
	private String address;
	private String phone_No;
	private String country;

	public Billing()
	{
		this.billingId="BILL"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBillingId() {
		return billingId;
	}

	public void setBillingId(String billingId) {
		this.billingId = billingId;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
