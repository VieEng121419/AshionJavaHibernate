package com.duongvietanh.dao;

import java.util.List;

import com.duongvietanh.model.Product;
import com.duongvietanh.model.ProductRelated;

public interface ProductRelatedDAO {
	public List<Product> listProductRelated(int id);

}
