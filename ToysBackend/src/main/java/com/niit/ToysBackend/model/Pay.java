package com.niit.ToysBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Pay {
	@Id
	private String pay_Id;
	private String pay_Method;
	private String status;
	public String getPay_Id() {
		return pay_Id;
	}
	public void setPay_Id(String pay_Id) {
		this.pay_Id = pay_Id;
	}
	public String getPay_Method() {
		return pay_Method;
	}
	public void setPay_Method(String pay_Method) {
		this.pay_Method = pay_Method;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
