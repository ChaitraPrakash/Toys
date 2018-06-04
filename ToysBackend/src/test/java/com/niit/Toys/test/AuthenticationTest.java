package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.AuthenticationDao;
import com.niit.ToysBackend.model.Authentication;

public class AuthenticationTest
{
	public static void main(String chaitra[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Authentication anno = (Authentication) ctx.getBean("authentication");
		AuthenticationDao annoDao =(AuthenticationDao)ctx.getBean("authenticationDao");
	     anno.setRoleId("101");
		 anno.setRoleName("ROLE_USER");
		 anno.setUserName("Chaitra");
		if (annoDao.saveorupdateAuthentication(anno) == true) 
		{
			System.out.println("Authentication is added successfully");
		} 
		else
		{
			System.out.println("Authentication not added");
		}
		anno.setRoleId("102");
		anno.setRoleName("ROLE_USER");
		anno.setUserName("Lava");
		if (annoDao.saveorupdateAuthentication(anno) == true)
		{
			System.out.println("Authentication is added successfully");
		} else {
			System.out.println("Authentication not added");
		}
		if (annoDao.deleteAuthentication(anno) == true)
		{
			System.out.println("Authentication deleted");
		} 
		else
		{
			System.out.println("Authentication not deleted");
		}
		anno =annoDao.getAuthentication("101");
		if (anno == null)
		{
			System.out.println("Authentication is empty");
		} 
		else
		{
			System.out.println("Authentication info");
			System.out.println(anno.getRoleId());
			System.out.println(anno.getRoleName());
			System.out.println(anno.getUserName());
		}
		List<Authentication> alist = annoDao.list();
		for (Authentication a : alist)
		{
			System.out.println(a.getRoleId());
			System.out.println(a.getRoleName());
			System.out.println(anno.getUserName());
		}
	}

}
