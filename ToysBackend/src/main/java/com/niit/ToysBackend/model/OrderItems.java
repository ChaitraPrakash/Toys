package com.niit.ToysBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component

public class OrderItems 
{
	@Id
	private String orderItemId;
	private String productId;
	
	public OrderItems()
	{
		this.orderItemId="ORDIT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
