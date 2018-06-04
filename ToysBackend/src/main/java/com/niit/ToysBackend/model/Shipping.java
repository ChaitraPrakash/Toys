package com.niit.ToysBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Shipping 
{
	@Id
private String shippingId;
private String shippingName;
private String Address;
private String PhoneNumber;
private String Country;


public Shipping()
{
	this.shippingId="SHIP"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
@ManyToOne
@JoinColumn(name="userId")
private User user;


public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getShippingId() {
	return shippingId;
}
public void setShippingId(String shippingId) {
	this.shippingId = shippingId;
}
public String getShippingName() {
	return shippingName;
}
public void setShippingName(String shippingName) {
	this.shippingName = shippingName;
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
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}



}
