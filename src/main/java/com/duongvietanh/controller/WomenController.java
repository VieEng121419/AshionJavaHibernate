package com.duongvietanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.duongvietanh.model.Product;
import com.duongvietanh.service.ProductService;

@Controller
public class WomenController {
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService pr) {
		this.productService = pr;	
	}
	
	@RequestMapping(value = "Womens")
	public String listProductsWomen(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProductWoman", this.productService.listCategoryWomen());
		return "women/women";
	}
}
