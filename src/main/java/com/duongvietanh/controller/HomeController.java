package com.duongvietanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duongvietanh.model.Product;
import com.duongvietanh.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService pr) {
		this.productService = pr;	
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productService.listProducts());
		model.addAttribute("listProductWoman", this.productService.listCategoryWomen());
		model.addAttribute("listProductMan", this.productService.listCategoryMen());
		model.addAttribute("listTrend", this.productService.listTrend());
		return "home/home";
	}

}
