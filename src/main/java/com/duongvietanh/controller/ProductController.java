package com.duongvietanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duongvietanh.model.Product;
import com.duongvietanh.service.ProductRelatedService;
import com.duongvietanh.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService pr) {
		this.productService = pr;	
	}
	
	@Autowired
	private ProductRelatedService productRelatedService;
	public void setProductrelatedService(ProductRelatedService prl) {
		this.productRelatedService = prl;	
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	public String listProducts(@PathVariable("id") int id, Model model) {
		model.addAttribute("category", new Product());
		model.addAttribute("getProduct", this.productService.getProduct(id));
		model.addAttribute("listProducts", this.productService.listProducts());
		model.addAttribute("ProductRelated", this.productRelatedService.listProductRelated(id));
		return "product/product";
	}

}
