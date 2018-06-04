package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Cart;

public interface CartDao {
	public boolean saveorupdateCart(Cart cart);

	public boolean deleteCart(Cart cart);

	public Cart getCart(String cartId);

	public List<Cart> list();
}
