package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.UserDao;
import com.niit.ToysBackend.model.User;

public class UserTest {
	public static void main(String chaitra[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		User use = (User) ctx.getBean("user");
		UserDao useDao = (UserDao) ctx.getBean("userDao");
		use.setUserId("U101");
		use.setUserName("User1");
		if (useDao.saveorupdateUser(use) == true) {
			System.out.println("User is added successfully");
		} else {
			System.out.println("User not added");
		}
		use.setUserId("U102");
		use.setUserName("Supplier2");
		use.setAddress("Address");
		use.setPhoneNumber("PhoneNumber");
		use.setEmail_Id("email_Id");
		use.setPassword("Password");

		if (useDao.saveorupdateUser(use) == true) {
			System.out.println("User is added successfully");
		} else {
			System.out.println("User not added");
		}
		if (useDao.deleteUser(use) == true) {
			System.out.println("User deleted");
		} else {
			System.out.println("User not deleted");
		}
		use = useDao.getUser("U101");
		if (use == null) {
			System.out.println("User is empty");
		} else {
			System.out.println("User info");
			System.out.println(use.getUserId());
			System.out.println(use.getUserName());
			System.out.println(use.getAddress());
			System.out.println(use.getEmail_Id());
			System.out.println(use.getPassword());
			System.out.println(use.getPhoneNumber());
		}
		List<User> ulist = useDao.list();
		for (User u : ulist) {
			System.out.println(u.getUserId());
			System.out.println(u.getUserName());
			System.out.println(u.getAddress());
			System.out.println(u.getPhoneNumber());
		}
	
	}
	
}
