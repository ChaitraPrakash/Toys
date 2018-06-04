package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.SupplierDao;
import com.niit.ToysBackend.model.Supplier;

public class SupplierTest
{
	public static void main(String chaitra[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Supplier sup = (Supplier) ctx.getBean("supplier");
		SupplierDao supDao = (SupplierDao) ctx.getBean("supplierDao");
		sup.setSupplierId("S101");
		sup.setSupplierName("Supplier1");
		if (supDao.saveorupdateSupplier(sup) == true) {
			System.out.println("Supplier is added successfully");
		} else {
			System.out.println("Supplier not added");
		}
		sup.setSupplierId("S102");
		sup.setSupplierName("Supplier2");
		sup.setAddress("Address");
		sup.setPhoneNumber("PhoneNumber");
		if (supDao.saveorupdateSupplier(sup) == true)
		{
			System.out.println("Supplier is added successfully");
		} else {
			System.out.println("Supplier not added");
		}
		if (supDao.deleteSupplier(sup) == true)
		{
			System.out.println("Supplier deleted");
		} else
		{
			System.out.println("Supplier not deleted");
		}
		sup = supDao.getSupplier("S101");
		if (sup == null) 
		{
			System.out.println("Supplier is empty");
		} else {
			System.out.println("Supplier info");
			System.out.println(sup.getSupplierId());
			System.out.println(sup.getSupplierName());
			System.out.println(sup.getAddress());
			System.out.println(sup.getPhoneNumber());
		}
		List<Supplier> slist = supDao.list();
		for (Supplier s : slist) {
			System.out.println(s.getSupplierId());
			System.out.println(s.getSupplierName());
			System.out.println(s.getAddress());
			System.out.println(s.getPhoneNumber());
		}
	}

	}
