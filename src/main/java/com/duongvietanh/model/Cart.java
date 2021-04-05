package com.duongvietanh.model;

import java.util.Map;

public class Cart {
	private Product product;
	private double Total_price;
	private int quantity;	
	
	public Cart() {
	}
	public Cart(Product product, double total_price, int quantity) {
		super();
		this.product = product;
		Total_price = total_price;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getTotal_price() {
		return Total_price;
	}
	
	public void setTotal_price(double total_price) {
		Total_price = total_price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
