package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.OrderItemsDao;
import com.niit.ToysBackend.model.OrderItems;

public class OrderItemsTest
{
	public static void main(String chaitra[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		OrderItems orderItems = (OrderItems) ctx.getBean("orderItems");
		OrderItemsDao orderItemsDao =(OrderItemsDao)ctx.getBean("orderItemsDao");
		orderItems.setOrderItemId("101");
		orderItems.setProductId("20");
		if (orderItemsDao.saveorupdateOrderItems(orderItems) == true)
		{
			System.out.println("OrderItems is added successfully");
		}
		else
		{
			System.out.println("OrderItems not added");
		}
		orderItems.setOrderItemId("102");
		orderItems.setProductId("20");
			
		
		if (orderItemsDao.saveorupdateOrderItems(orderItems) == true)
		{
			System.out.println("OrderItems is added successfully");
		} 
		else
		{
			System.out.println("OrderItems not added");
		}
		orderItems =orderItemsDao.getOrderItems("101");
		
		if (orderItemsDao.deleteOrderItems(orderItems) == true) 
		{
			System.out.println("OrderItems deleted");
		}
		else
		{
			System.out.println("OrderItems not deleted");
		}
		orderItems =orderItemsDao.getOrderItems("102");
		if (orderItems == null) 
		{
			System.out.println("OrderItems is empty");
		} 
		else 
		{
			System.out.println("OrderItems info");
			System.out.println(orderItems.getOrderItemId());
			System.out.println(orderItems.getProductId());
			
		}
		List<OrderItems> olist = orderItemsDao.list();
		for (OrderItems o : olist) 
		{
			System.out.println(o.getOrderItemId());
			System.out.println(o.getProductId());
		
		}
	}
}
