package com.duongvietanh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.HashMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.duongvietanh.model.Cart;
import com.duongvietanh.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	public void setCartService(CartService cs) {
		this.cartService = cs;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/Cart")
	public ModelAndView listCart()
	{
		ModelAndView listcart  = new ModelAndView("cart/cart");
		return listcart;
	}
	
	@RequestMapping(value = "AddCart/{id}", method = RequestMethod.GET)
	public String AddCart(HttpServletRequest request ,HttpSession session, @PathVariable int id) {
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>)session.getAttribute("CART");
		if (cart == null)
		{
			cart = new HashMap<Integer, Cart>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("CART", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/AddCartMul/{id}/{quanty}")
	public String AddCartMul(HttpServletRequest request ,HttpSession session, @PathVariable int id, @PathVariable int quanty) {
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>)session.getAttribute("CART");
		if (cart == null)
		{
			cart = new HashMap<Integer, Cart>();
		}
		
		cart = cartService.AddCartMul(id, quanty, cart);
		session.setAttribute("CART", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request ,HttpSession session, @PathVariable int id, @PathVariable int quanty) {
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>)session.getAttribute("CART");
		if (cart == null)
		{
			cart = new HashMap<Integer, Cart>();
		}
		
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("CART", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "DeleteCart/{id}", method = RequestMethod.GET)
	public String DeleteCart(HttpServletRequest request ,HttpSession session, @PathVariable int id) 
	{
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>)session.getAttribute("CART");
		if (cart == null)
		{
			cart = new HashMap<Integer, Cart>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("CART", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");		
	}

}
//