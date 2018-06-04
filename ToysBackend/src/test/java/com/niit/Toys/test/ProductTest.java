package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.ProductDao;
import com.niit.ToysBackend.model.Product;

public class ProductTest {
	public static void main(String chaitra[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Product pro = (Product) ctx.getBean("product");
		ProductDao proDao = (ProductDao) ctx.getBean("productDao");
		pro.setProductId("P101");
		pro.setProductName("Product1");
		if (proDao.saveorupdateProduct(pro) == true)
		{
			System.out.println("Product is added successfully");
		} else {
			System.out.println("Product not added");
		}
		pro.setProductId("P102");
		pro.setProductName("Product2");
		pro.setProductDescription("Description");
		pro.setQuantity(0);
		pro.setPrice(0.0);
		if (proDao.saveorupdateProduct(pro) == true)
		{
			System.out.println("Product is added successfully");
		} else {
			System.out.println("Product not added");
		}
		if (proDao.deleteProduct(pro) == true)
		{
			System.out.println("Product deleted");
		} else {
			System.out.println("Product not deleted");
		}
		pro = proDao.getProduct("P101");
		if (pro == null) {
			System.out.println("Product is empty");
		} else 
		{
			System.out.println("Product info");
			System.out.println(pro.getProductId());
			System.out.println(pro.getProductName());
			System.out.println(pro.getProductDescription());
			System.out.println(pro.getQuantity());
			System.out.println(pro.getPrice());
		}
		List<Product> plist = proDao.list();
		for (Product p : plist) 
		{
			System.out.println(p.getProductId());
			System.out.println(p.getProductName());
			System.out.println(p.getProductDescription());
			System.out.println(p.getQuantity());
			System.out.println(p.getPrice());
		}
	}

}
