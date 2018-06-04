package com.niit.ToysBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table

public class CartItems {
	@Id
	private String cartItemsId;
	private double price;

	public CartItems() {
		this.cartItemsId = "CARTIT" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	@OneToOne
	@JoinColumn(name = "productId")
	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getCartItemsId() {
		return cartItemsId;
	}

	public void setCartItemsId(String cartItemsId) {
		this.cartItemsId = cartItemsId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
