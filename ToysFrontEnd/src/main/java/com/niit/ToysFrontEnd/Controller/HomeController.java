package com.niit.ToysFrontEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ToysBackend.dao.ProductDao;
import com.niit.ToysBackend.dao.UserDao;
import com.niit.ToysBackend.model.Product;
import com.niit.ToysBackend.model.User;

@Controller

public class HomeController 
{
	
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	Product  product;
	@Autowired
	ProductDao productDao;
	
    @RequestMapping("/")
	public ModelAndView  home(@ModelAttribute("user") User user)
	{
    	ModelAndView mv= new ModelAndView("HOMEPAGE");
    	mv.addObject("user", user);
		return mv;
	}
    
    @RequestMapping("/ShoppingZone")
    public ModelAndView shop()
    {
    	ModelAndView mv= new ModelAndView("ShoppingZone");
       List<Product> products=productDao.list();
       mv.addObject("products", products);
    	return mv;
    }
    
    
//    @RequestMapping("/login")
//    public String login()
//    {
//    	return "Login";
//    	
//    }

    @RequestMapping("/Header")
    public String Header()
    {
    	return "Header";
    }
    
    @RequestMapping("/Footer")
    public String Footer()
    {
    	return "Footer";
    }
    
    @RequestMapping("/About")
    public String About()
    {
    	return "AboutUs";
    }
    
    @RequestMapping("/Contact")
    public String Contact()
    {
    	return "ContactUs";
    }

}
