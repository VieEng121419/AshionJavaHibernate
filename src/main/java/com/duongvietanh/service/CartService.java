package com.duongvietanh.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.duongvietanh.dao.CartDAO;
import com.duongvietanh.model.Cart;

public interface CartService {
	public HashMap<Integer,Cart> AddCart(int id, HashMap<Integer,Cart> cart);
	public HashMap<Integer,Cart> EditCart(int id,int quanty, HashMap<Integer,Cart> cart);
	public HashMap<Integer,Cart> DeleteCart(int id, HashMap<Integer,Cart> cart);
	public int TotalQuanty(HashMap<Integer, Cart> cart);
	public double TotalPrice(HashMap<Integer, Cart> cart);
	public HashMap<Integer, Cart> AddCartMul(int id, int quanty, HashMap<Integer, Cart> cart);
}
