package com.duongvietanh.service;

import java.util.List;

import com.duongvietanh.model.Product;

public interface ProductService {
	public List<Product> listProducts();
	public List<Product> listCategoryWomen();
	public List<Product> listCategoryMen();
	public List<Product> listTrend();
	public Product getProduct(int id);
	public void deleteProduct(int id);
	public void insertProduct(Product product);
}