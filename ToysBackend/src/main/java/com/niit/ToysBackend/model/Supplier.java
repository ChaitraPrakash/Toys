package com.niit.ToysBackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Supplier {

	@Id
	private String supplierId;
	private String supplierName;
	private String Address;
	private String  PhoneNumber;
	
	
	@OneToMany(mappedBy="supplier")
	private List<Product> product;	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getSupplierId() {
		return supplierId;
	}
	
	public Supplier()
	{
		this.supplierId="SUPP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
	
	}


