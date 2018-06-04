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
@Table(name="Orders")
@Component

public class Order
{
	@Id
	private String orderId;
	private String orderDate;
	private String orderTime;
	private double GrandTotal;
	
	public Order()
	{
		this.orderId="ORD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@OneToMany(mappedBy="order")
	private List<OrderItems> orderItems;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billingId")
	private Billing billing;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shippingId")
	private Shipping shipping;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public double getGrandTotal() {
		return GrandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		GrandTotal = grandTotal;
	}
	
	

	

}
