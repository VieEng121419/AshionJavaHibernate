package com.duongvietanh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duongvietanh.dao.ProductDAO;
import com.duongvietanh.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@Transactional
	public List<Product> listProducts() {
		return this.productDAO.listProducts();
	}
	@Transactional
	public List<Product> listCategoryWomen() {
		return this.productDAO.listCategoryWomen();
	}
	@Transactional
	public List<Product> listCategoryMen() {
		return this.productDAO.listCategoryMen();
	}
	@Transactional
	public List<Product> listTrend() {
		return this.productDAO.listTrend();
	}
	@Transactional
	public Product getProduct(int id) {
		return this.productDAO.getProduct(id);
	}
	@Transactional
	public void deleteProduct(int id)
	{
		productDAO.deleteProduct(id);
	}
	
	@Transactional
	public void insertProduct(Product product)
	{
		this.productDAO.insertProduct(product);		
	}
}