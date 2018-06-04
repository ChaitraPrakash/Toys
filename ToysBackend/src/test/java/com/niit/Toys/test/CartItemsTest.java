package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.CartItemsDao;
import com.niit.ToysBackend.model.CartItems;

public class CartItemsTest 
{
	public static void main(String chaitra[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		CartItems cartItems = (CartItems) ctx.getBean("cartItems");
		CartItemsDao cartItemsDao =(CartItemsDao)ctx.getBean("cartItemsDao");
	     cartItems.setCartItemsId("101");
		 cartItems.setPrice(20);
		if (cartItemsDao.saveorupdateCartItems(cartItems) == true)
		{
			System.out.println("CartItems is added successfully");
		}
		else
		{
			System.out.println("CartItems not added");
		}
	     cartItems.setCartItemsId("101");
		 cartItems.setPrice(20);
			
		
		if (cartItemsDao.saveorupdateCartItems(cartItems) == true)
		{
			System.out.println("CartItems is added successfully");
		} 
		else
		{
			System.out.println("CartItems not added");
		}
		if (cartItemsDao.deleteCartItems(cartItems) == true)
		{
			System.out.println("CartItems deleted");
		}
		else
		{
			System.out.println("Cart not deleted");
		}
		cartItems =cartItemsDao.getCartItems("101");
		if (cartItems == null)
		{
			System.out.println("Cart is empty");
		} 
		else
		{
			System.out.println("Cart info");
			System.out.println(cartItems.getCartItemsId());
			System.out.println(cartItems.getPrice());
			
		}
		List<CartItems> clist = cartItemsDao.list();
		for (CartItems c : clist)
		{
			System.out.println(c.getCartItemsId());
			System.out.println(c.getPrice());
		
			
			
		}
	}



}
