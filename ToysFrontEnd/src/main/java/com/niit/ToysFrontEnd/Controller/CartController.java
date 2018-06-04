package com.niit.ToysFrontEnd.Controller;

import java.util.List;

import javax.servlet.http.HttpSession; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ToysBackend.dao.CartDao;
import com.niit.ToysBackend.dao.CartItemsDao;
import com.niit.ToysBackend.dao.ProductDao;
import com.niit.ToysBackend.dao.UserDao;
import com.niit.ToysBackend.model.Cart;
import com.niit.ToysBackend.model.CartItems;
import com.niit.ToysBackend.model.Product;
import com.niit.ToysBackend.model.User;

@Controller
public class CartController {
	@Autowired
	User user;

	@Autowired
	UserDao userDao;

	@Autowired
	Product product;

	@Autowired
	ProductDao productDao;

	@Autowired
	Cart cart;

	@Autowired
	CartDao cartDao;

	@Autowired
	CartItems cartItems;

	@Autowired
	CartItemsDao cartItemsDao;

	@RequestMapping("/addtocart/{productId}")
	public ModelAndView cart(@PathVariable("productId") String id, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getEmail(currusername);

			if (user == null) {
				// int items=0;
				Product product1 = productDao.getProduct(id);
				CartItems cartItem = new CartItems();
				cartItem.setCart(cart);
				cartItem.setProduct(product1);
				cartItem.setPrice(product1.getPrice());
				cartItemsDao.saveorupdateCartItems(cartItem);
				cart.setGrandTotal(cart.getGrandTotal() + product1.getPrice());
				cart.setTotalItems(cart.getTotalItems() + 1);
				cartDao.saveorupdateCart(cart);
				session.setAttribute("Items", cart.getCartItems());
				session.setAttribute("GrandTotal", cart.getGrandTotal());
				return new ModelAndView("redirect:/");
			} else {
				cart = u.getCart();
				// ModelAndView mv= new ModelAndView();
				// Cart cart= new Cart();
				// mv.addObject("cart", cart);
				Product product1 = productDao.getProduct(id);
				CartItems cartItem = new CartItems();
				cartItem.setCart(cart);
				cartItem.setProduct(product1);
				cartItem.setPrice(product1.getPrice());
				cartItemsDao.saveorupdateCartItems(cartItem);
				cart.setGrandTotal(cart.getGrandTotal() + product1.getPrice());
				cart.setTotalItems(cart.getTotalItems() + 1);
				cartDao.saveorupdateCart(cart);
				session.setAttribute("Items", cart.getCartItems());
				session.setAttribute("GrandTotal", cart.getGrandTotal());
				return new ModelAndView("redirect:/");

			}
		}
		return new ModelAndView("redirect:/ShoppingZone");
	}

	@RequestMapping(value = "/checkout")
	public String viewcart(Model model, HttpSession session) {
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {

			String currusername = authentication.getName();
			User u = userDao.getEmail(currusername);
			Cart cart = u.getCart();
			List<CartItems> cartItem = cartItemsDao.getlist(u.getCart().getCartId());
			if (cartItem == null || cartItem.isEmpty()) {
				session.setAttribute("Items", 0);
				model.addAttribute("GrandTotal", 0.0);
				model.addAttribute("Message", "No items is added to cart");
				return "checkout";
			}
			model.addAttribute("CartItems", cartItem);
			model.addAttribute("GrandTotal", cart.getGrandTotal());
			session.setAttribute("Items", cart.getCartItems());
			session.setAttribute("CartId", cart.getCartId());
			return "checkout";
		}
		return "redirect:/checkout";
	}

	@RequestMapping(value = "/Remove/{Cartitem_Id}")
	public ModelAndView RemoveFromCart(@PathVariable("Cartitem_Id") String id) {
		ModelAndView mv = new ModelAndView("redirect:/checkout");
		cartItems = cartItemsDao.getCartItems(id);
		Cart c = cartItems.getCart();
		c.setGrandTotal(c.getGrandTotal() - cartItems.getPrice());
		c.setTotalItems(c.getTotalItems() - 1);
		cartDao.saveorupdateCart(c);
		cartItemsDao.deleteCartItems(cartItems);
		return mv;
	}

	@RequestMapping(value = "/RemoveAll")
	public String RemoveAllFromCart(Model model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getEmail(currusername);
			Cart c = cartDao.getCart(u.getCart().getCartId());
			List<CartItems> cartItem = cartItemsDao.getlist(u.getCart().getCartId());
			for (CartItems c1 : cartItem) {
				// cartItemsDao.get(c1.getCartitem_Id());
				cartItemsDao.deleteCartItems(c1);
			}

			c.setGrandTotal(0.0);
			c.setTotalItems(0);
			cartDao.saveorupdateCart(c);
			session.setAttribute("items", c.getTotalItems());
			return "redirect:/checkout";
		}

		else 
		{
			return "redirect:/";
		}

	}

}
