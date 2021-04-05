package com.duongvietanh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duongvietanh.dao.ProductRelatedDAO;
import com.duongvietanh.model.Product;
import com.duongvietanh.model.ProductRelated;

@Service
public class ProductRelatedServiceImpl implements ProductRelatedService{
	
	@Autowired
	private ProductRelatedDAO productRelatedDAO;
	public void setProductRelatedDAO(ProductRelatedDAO productrelatedDAO) {
		this.productRelatedDAO = productrelatedDAO;
	}
	
	@Override
	@Transactional
	public List<Product> listProductRelated(int id) {
		return this.productRelatedDAO.listProductRelated(id);
		
	}
}
