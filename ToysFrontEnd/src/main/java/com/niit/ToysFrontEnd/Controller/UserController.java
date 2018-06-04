package com.niit.ToysFrontEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ToysBackend.dao.UserDao;
import com.niit.ToysBackend.model.Cart;
import com.niit.ToysBackend.model.User;

@Controller
public class UserController 
{
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/User")
	public ModelAndView User()
	{
		ModelAndView mv=new ModelAndView("User");
		List<User> userlist=userDao.list();
		mv.addObject("user",new User());
		mv.addObject("users",userlist);
		return mv;
	}
	@RequestMapping("/adduser")
	public ModelAndView adduser(@ModelAttribute("user") User user)
	{
		ModelAndView mv=new ModelAndView();
		Cart c= new Cart();
		user.setCart(c);
		if(userDao.saveorupdateUser(user)==true)
		{
			mv.addObject("msg1","User Added Successfully");
		}
		else
		{
			mv.addObject("msg1","User  Not Added ");
		}
//		return mv;
		mv.setViewName("redirect:/");
		return mv;
	}
//	@RequestMapping("/editUser/{userId}")
//	public ModelAndView edituser(@PathVariable("userId")String userId )	
//	{
//		ModelAndView mv=new ModelAndView("user");
//		user=userDao.getUser(userId);
//		mv.addObject("user",user);
//		List<User>userlist=userDao.list();
//		mv.addObject("user",user);
//	return mv;
//	}
//	
//	@RequestMapping("/deleteUser/{userId}")
//	public ModelAndView deleteuser(@PathVariable("userId")String userId )	
//	{
//		ModelAndView mv=new ModelAndView("redirect:/User");
//		user=userDao.getUser(userId);
//		
//		List<User> categorylist=userDao.list();
//		mv.addObject("categories",categorylist);
//		
//		if(userDao.deleteUser(user)==true)
//		{
//			mv.addObject("msg", "User Deleted");
//		}
//		else
//		{
//			mv.addObject("msg", "User not Deleted");
//		}
//	return mv;
//	}


}
