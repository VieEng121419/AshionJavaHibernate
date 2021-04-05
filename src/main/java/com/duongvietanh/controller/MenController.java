package com.duongvietanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duongvietanh.model.Product;
import com.duongvietanh.service.ProductService;

@Controller
public class MenController {
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService pr) {
		this.productService = pr;	
	}
	
	@RequestMapping(value = "Mens")
	public String listProductsWomen(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProductMan", this.productService.listCategoryMen());
		return "men/men";
	}
}
