package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.ShippingDao;
import com.niit.ToysBackend.model.Shipping;

public class ShippingTest
{
	public static void main(String chaitra[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Shipping shipping = (Shipping) ctx.getBean("shipping");
		ShippingDao shippingDao =(ShippingDao)ctx.getBean("shippingDao");
		shipping.setShippingId("101");
		shipping.setShippingName("Chaitra");
		shipping.setAddress("dfnbjdhf;o");
		shipping.setPhoneNumber("2343657");
		
		
		if (shippingDao.saveorupdateShipping(shipping) == true) 
		{
			System.out.println("Shipping is added successfully");
		} 
		else
		{
			System.out.println("Shipping not added");
		}
		shipping.setShippingId("102");
		shipping.setShippingName("CRUISE");
		shipping.setAddress("ABCD");
		shipping.setPhoneNumber("734620341");
		
			
		
		if (shippingDao.saveorupdateShipping(shipping) == true)
		{
			System.out.println("Shipping is added successfully");
		}
		else
		{
			System.out.println("Shipping not added");
		}
		
		shipping=shippingDao.getShipping("102");
		if (shippingDao.deleteShipping(shipping) == true)
		{
			System.out.println("Shipping deleted");
		} 
		else
		{
			System.out.println("Shipping not deleted");
		}
		shipping =shippingDao.getShipping("101");
		if (shipping == null) 
		{
			System.out.println("Shipping is empty");
		}
		else
		{
			System.out.println("Shipping info");
			System.out.println(shipping.getShippingId());
			System.out.println(shipping.getShippingName());
			System.out.println(shipping.getAddress());
			System.out.println(shipping.getPhoneNumber());
		}
		List<Shipping> slist = shippingDao.list();
		for (Shipping s : slist) {
			System.out.println(s.getShippingId());
			System.out.println(s.getShippingName());
			System.out.println(s.getAddress());
			System.out.println(s.getPhoneNumber());

		}
	}

}
