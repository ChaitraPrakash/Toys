package com.niit.ToysBackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Cart {
	@Id
	private String cartId;
	private double grandTotal = 0.0;
	private int totalItems = 0;
	
	public Cart()
	{
		this.cartId="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
//	@OneToOne
//	@JoinColumn(name="userId")
//	private User user;
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	@OneToMany(mappedBy="cart")
	private List<CartItems> cartItems;
	
	
	
	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

}
