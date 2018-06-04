package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.CartDao;
import com.niit.ToysBackend.model.Cart;

public class CartTest
{
	public static void main(String chaitra[]) 
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Cart cart = (Cart) ctx.getBean("cart");
		CartDao cartDao =(CartDao)ctx.getBean("cartDao");
	     cart.setCartId("101");
		 cart.setGrandTotal(0.0);
		 cart.setTotalItems(0);
		if (cartDao.saveorupdateCart(cart) == true)
		{
			System.out.println("Cart is added successfully");
		} 
		else
		{
			System.out.println("Cart not added");
		}
	     cart.setCartId("101");
		 cart.setGrandTotal(0.0);
		 cart.setTotalItems(0);
			
		
		if (cartDao.saveorupdateCart(cart) == true) 
		{
			System.out.println("Cart is added successfully");
		} 
		else
		{
			System.out.println("Cart not added");
		}
		if (cartDao.deleteCart(cart) == true)
		{
			System.out.println("Cart deleted");
		} 
		else
		{
			System.out.println("Cart not deleted");
		}
		cart =cartDao.getCart("101");
		if (cart == null)
		{
			System.out.println("Cart is empty");
		}
		else
		{
			System.out.println("Cart info");
			System.out.println(cart.getCartId());
			System.out.println(cart.getGrandTotal());
			System.out.println(cart.getTotalItems());
			
		}
		List<Cart> clist = cartDao.list();
		for (Cart c : clist)
		{
			System.out.println(c.getCartId());
			System.out.println(c.getGrandTotal());
			System.out.println(c.getTotalItems());
			
			
		}
	}



}
