package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.OrderDao;
import com.niit.ToysBackend.model.Order;

public class OrderTest
{
	public static void main(String chaitra[])
	{
	
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	Order order = (Order) ctx.getBean("order");
	OrderDao orderDao =(OrderDao)ctx.getBean("orderDao");
	order.setOrderId("101");
	order.setOrderDate("4-6-12");
	order.setOrderTime("4:25:34");
	order.setGrandTotal(45000);
	
	if (orderDao.saveorupdateOrder(order) == true)
	{
		System.out.println("Order is added successfully");
	}
	else
	{
		System.out.println("Order not added");
	}
	
	order.setOrderId("102");
	order.setOrderDate("4-6-12");
	order.setOrderTime("4:25:34");
	order.setGrandTotal(45000);
	
	
	
	if (orderDao.deleteOrder(order) == true) 
	{
		System.out.println("Order deleted");
	}
	else
	{
		System.out.println("Order not deleted");
	}
	order =orderDao.getOrder("101");
	if (order == null) 
	{
		System.out.println("Order is empty");
	} 
	else 
	{
		System.out.println("Order info");
		System.out.println(order.getOrderId());
		System.out.println(order.getOrderDate());
		System.out.println(order.getOrderTime());
		System.out.println(order.getGrandTotal());

		
		
	}
	List<Order> olist = orderDao.list();
	for (Order o : olist) 
	{
		System.out.println(o.getOrderId());
		System.out.println(o.getOrderDate());
		System.out.println(o.getOrderTime());
		System.out.println(o.getGrandTotal());

	
	}
}


}
