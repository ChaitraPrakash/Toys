package com.niit.ToysBackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class User {

	@Id
	private String userId;
	private String userName;
	private String Address;
	private String PhoneNumber;
	private String email_Id;
	private String password;
	private String role="ROLE_USER";
	
	public User()
	{
		this.userId="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@OneToOne
	@JoinColumn(name="billingId")
	private Billing billing;
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@OneToMany(mappedBy="user")
	private List<Shipping> shipping;
	
		
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Shipping> getShipping() {
		return shipping;
	}

	public void setShipping(List<Shipping> shipping) {
		this.shipping = shipping;
	}
	
	
	public String getUserId() 
	{
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail_Id() {
		return email_Id;
	}
	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
