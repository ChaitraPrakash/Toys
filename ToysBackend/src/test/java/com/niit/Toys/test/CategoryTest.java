package com.niit.Toys.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ToysBackend.dao.Categorydao;
import com.niit.ToysBackend.model.Category;

public class CategoryTest {
	public static void main(String chaitra[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Category cat = (Category) ctx.getBean("category");
		Categorydao catDao = (Categorydao) ctx.getBean("categoryDao");
		cat.setCatId("C101");
		cat.setCatName("Category1");
		if (catDao.saveorupdateCategory(cat) == true) {
			System.out.println("Category is added successfully");
		} else
		{
			System.out.println("Category not added");
		}
		cat.setCatId("C102");
		cat.setCatName("Category2");
		if (catDao.saveorupdateCategory(cat) == true) {
			System.out.println("Category is added successfully");
		} else {
			System.out.println("Category not added");
		}
		if (catDao.deleteCategory(cat) == true) {
			System.out.println("Category deleted");
		} else {
			System.out.println("Category not deleted");
		}
		cat = catDao.getCategory("C101");
		if (cat == null) {
			System.out.println("Category is empty");
		} else {
			System.out.println("Category info");
			System.out.println(cat.getCatId());
			System.out.println(cat.getCatName());
		}
		List<Category> clist = catDao.list();
		for (Category c : clist) {
			System.out.println(c.getCatId());
			System.out.println(c.getCatName());
		}
	}
}
