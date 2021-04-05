package com.duongvietanh.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duongvietanh.dao.CartDAO;
import com.duongvietanh.dao.ProductDAO;
import com.duongvietanh.model.Cart;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDAO cartDAO;
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	public HashMap<Integer, Cart> AddCart(int id, HashMap<Integer, Cart> cart) {
		
		return cartDAO.AddCart(id, cart);
	}

	public HashMap<Integer, Cart> EditCart(int id, int quanty, HashMap<Integer, Cart> cart) {
		
		return cartDAO.EditCart(id, quanty, cart);
	}

	public HashMap<Integer, Cart> DeleteCart(int id, HashMap<Integer, Cart> cart) {
		
		return cartDAO.DeleteCart(id, cart);
	}

	public int TotalQuanty(HashMap<Integer, Cart> cart) {
		return cartDAO.TotalQuanty(cart);
	}

	public double TotalPrice(HashMap<Integer, Cart> cart) {
		return cartDAO.TotalPrice(cart);
	}

	public HashMap<Integer, Cart> AddCartMul(int id, int quanty, HashMap<Integer, Cart> cart) {
		return cartDAO.AddCartMul(id, quanty, cart);
	}

	
}
