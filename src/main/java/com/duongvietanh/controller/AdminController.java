package com.duongvietanh.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.duongvietanh.model.Product;
import com.duongvietanh.model.User;
import com.duongvietanh.service.ProductService;

@Controller
public class AdminController extends HttpServlet{
	@Autowired
	private ProductService productService;	
	
	@RequestMapping(value = "Admin")
	public String listProductsAdmin(Model model) {
		model.addAttribute("listProducts", this.productService.listProducts());
		return "admin/admin";
	}
	
	@RequestMapping(value="AddProduct", method = RequestMethod.GET)
	public ModelAndView showAddProduct() {
		ModelAndView admininsert = new ModelAndView("admin/admininsert");
		admininsert.addObject("product", new Product());
		return admininsert;
	}
	
	@RequestMapping(value="AddProduct", method = RequestMethod.POST)
	public String createPro(@ModelAttribute("product") Product product) {
		this.productService.insertProduct(product); 
		return "redirect:Admin";
	}
	
	@RequestMapping(value = "DeleteProduct/{id}")
	public String deleteProductsAdmin(@PathVariable("id") int id, Model model,HttpServletRequest request) {
		productService.deleteProduct(id);
		model.addAttribute("listProducts", this.productService.listProducts());
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="UpdateProduct/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateProduct(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		ModelAndView adminupdate = new ModelAndView("admin/adminupdate");
		model.addAttribute("getProductUpdate", this.productService.getProduct(id));
		adminupdate.addObject("product", new Product());
		return adminupdate;
	}
	
}
