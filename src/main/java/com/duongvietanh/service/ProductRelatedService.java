package com.duongvietanh.service;

import java.util.List;

import com.duongvietanh.model.Product;
import com.duongvietanh.model.ProductRelated;

public interface ProductRelatedService {
	public List<Product> listProductRelated(int id);
}
