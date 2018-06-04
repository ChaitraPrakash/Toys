package com.niit.ToysFrontEnd.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ToysBackend.dao.ProductDao;
import com.niit.ToysBackend.model.Product;

@Controller

public class ProductController 
{
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@RequestMapping("/Product")
	public ModelAndView Product()
	{
		ModelAndView mv=new ModelAndView("Product");
		List<Product> productlist=productDao.list();
		mv.addObject("product",new Product());
		mv.addObject("products",productlist);
		return mv;
	}
	@RequestMapping(value="/addProduct" , method=RequestMethod.POST)
	public ModelAndView addproduct(HttpServletRequest req,@RequestParam("pimg")MultipartFile   file, @ModelAttribute("product")Product product)
	{
		ModelAndView mv=new ModelAndView("redirect:/Product");
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		product.setImageName(filename);
		if(productDao.saveorupdateProduct(product)==true)
		{
			mv.addObject("msg1","Product Added Successfully");
		}
		else
		{
			mv.addObject("msg1","Product  Not Added ");
		}
		try
		{
			byte[ ] imagebyte=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/Resources/"+filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(Exception e)
		{
			
		}
		return mv;
	}
	@RequestMapping("/editProduct/{productId}")
	public ModelAndView editproduct(@PathVariable("productId")String productId )	
	{
		ModelAndView mv=new ModelAndView("Product");
		product=productDao.getProduct(productId);
		mv.addObject("product",product);
		List<Product>productlist=productDao.list();
		mv.addObject("products",productlist);
	return mv;
	}
	
	@RequestMapping("/deleteProduct/{productId}")
	public ModelAndView deleteproduct(@PathVariable("productId")String productId )	
	{
		ModelAndView mv=new ModelAndView("redirect:/Product");
		product=productDao.getProduct(productId);
		
		List<Product> productlist=productDao.list();
		mv.addObject("products",productlist);
		
		if(productDao.deleteProduct(product)==true)
		{
			mv.addObject("msg", "Product Deleted");
		}
		else
		{
			mv.addObject("msg", "Product not Deleted");
		}
	return mv;
	}

}
