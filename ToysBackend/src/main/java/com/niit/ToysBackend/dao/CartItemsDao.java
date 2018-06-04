package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.CartItems;

public interface CartItemsDao
{
	public boolean saveorupdateCartItems(CartItems cartItems);

	public boolean deleteCartItems(CartItems cartItems);

	public CartItems getCartItems(String cartItemsId);

	public List<CartItems> list();

	public List<CartItems> getlist(String cartId);


}
