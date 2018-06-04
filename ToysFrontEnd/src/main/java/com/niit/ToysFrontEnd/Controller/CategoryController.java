package com.niit.ToysFrontEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ToysBackend.dao.Categorydao;
import com.niit.ToysBackend.model.Category;
@Controller
public class CategoryController 
{
	@Autowired
	Category category;
	@Autowired
	Categorydao categoryDao;
	@RequestMapping("/Category")
	public ModelAndView Category()
	{
		ModelAndView mv=new ModelAndView("Category");
		List<Category> catlist=categoryDao.list();
		mv.addObject("category",new Category());
		mv.addObject("categories",catlist);
		return mv;
	}
	@RequestMapping("/addCategory")
	public ModelAndView addcat(@ModelAttribute("category")Category category)
	{
		ModelAndView mv=new ModelAndView("redirect:/Category");
		if(categoryDao.saveorupdateCategory(category)==true)
		{
			mv.addObject("msg1","Category Added Successfully");
		}
		else
		{
			mv.addObject("msg1","Category  Not Added ");
		}
		return mv;
	}
	@RequestMapping("/editCategory/{catId}")
	public ModelAndView editcategory(@PathVariable("catId")String categoryId )	
	{
		ModelAndView mv=new ModelAndView("Category");
		category=categoryDao.getCategory(categoryId);
		mv.addObject("category",category);
		List<Category> categorylist=categoryDao.list();
		mv.addObject("categories",categorylist);
	return mv;
	}
	
	@RequestMapping("/deleteCategory/{catId}")
	public ModelAndView deletecategory(@PathVariable("catId")String categoryId )	
	{
		ModelAndView mv=new ModelAndView("redirect:/Category");
		category=categoryDao.getCategory(categoryId);
		
		List<Category> categorylist=categoryDao.list();
		mv.addObject("categories",categorylist);
		
		if(categoryDao.deleteCategory(category)==true)
		{
			mv.addObject("msg", "Category Deleted");
		}
		else
		{
			mv.addObject("msg", "Category not Deleted");
		}
	return mv;
	}
}
		
