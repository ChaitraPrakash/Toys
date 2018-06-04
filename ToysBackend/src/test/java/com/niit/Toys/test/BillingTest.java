package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.BillingDao;
import com.niit.ToysBackend.dao.UserDao;
import com.niit.ToysBackend.model.Billing;
import com.niit.ToysBackend.model.User;

public class BillingTest
{
	public static void main(String chaitra[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Billing bill = (Billing) ctx.getBean("billing");
		BillingDao billDao =(BillingDao)ctx.getBean("billingDao");
		User  user=(User) ctx.getBean("user");
		UserDao userDao =(UserDao)ctx.getBean("userDao");
	     bill.setBillingId("101");
		 bill.setBillingName("Chaitra");
		 bill.setAddress("123njhd");
		 bill.setPhone_No("9902336780");
		 bill.setCountry("India");
		 
		if (billDao.saveorupdateBilling(bill) == true)
		{
			System.out.println("Billing is added successfully");
		}
		else
		{
			System.out.println("Billing not added");
		}
		      bill.setBillingId("201");
			 bill.setBillingName("Lava");
			 bill.setAddress("123njhd");
			 bill.setPhone_No("9902336780");
			 bill.setCountry("India");
			
		
		
		if (billDao.deleteBilling(bill) == true)
		{
			System.out.println("Billing deleted");
		} 
		else
		{
			System.out.println("Billing not deleted");
		}
		bill =billDao.getBilling("101");
		if (bill == null)
		{
			System.out.println("Billing is empty");
		} 
		else
		{
			System.out.println("Billing info");
			System.out.println(bill.getBillingId());
			System.out.println(bill.getBillingName());
			System.out.println(bill.getAddress());
			System.out.println(bill.getPhone_No());
			System.out.println(bill.getCountry());
			
		}
		List<Billing> blist = billDao.list();
		for (Billing b : blist) {
			System.out.println(b.getBillingId());
			System.out.println(b.getBillingName());
			System.out.println(b.getAddress());
			System.out.println(b.getPhone_No());
			System.out.println(b.getCountry());
			
			
		}
	}

 

}
