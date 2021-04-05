package com.duongvietanh.dao;

import java.util.Map;
import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duongvietanh.model.Cart;
import com.duongvietanh.model.Product;
@Transactional
@Repository
public class CartDAOImpl implements CartDAO {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Autowired
	private ProductDAO productDAO;
	public void setProductDAO(ProductDAO productDAO)
	{
		this.productDAO = productDAO;
	}
	
	public HashMap<Integer, Cart> AddCart(int id, HashMap<Integer, Cart> cart) {
		Cart itemCart = new Cart();
		Product product = productDAO.getProduct(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotal_price(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotal_price(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Integer, Cart> EditCart(int id, int quanty, HashMap<Integer, Cart> cart) {
		if (cart == null) {
			return cart;
		}
		Cart itemCart = new Cart();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quanty);
			itemCart.setTotal_price(quanty * itemCart.getProduct().getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Integer, Cart> DeleteCart(int id, HashMap<Integer, Cart> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int TotalQuanty(HashMap<Integer, Cart> cart) {
		int totalQuanty = 0;
		for (Map.Entry<Integer, Cart> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuantity();
		}
		return totalQuanty;
	}

	public double TotalPrice(HashMap<Integer, Cart> cart) {
		double totalPrice = 0;
		for (Map.Entry<Integer, Cart> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotal_price();
		}
		return totalPrice;
	}

	@Override
	public HashMap<Integer, Cart> AddCartMul(int id, int quanty, HashMap<Integer, Cart> cart) {
		Cart itemCart = new Cart();
		Product product = productDAO.getProduct(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + quanty);
			itemCart.setTotal_price(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuantity(quanty);
			itemCart.setTotal_price(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}
}
