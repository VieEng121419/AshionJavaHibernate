package com.duongvietanh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.duongvietanh.model.User;
import com.duongvietanh.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="Login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView login = new ModelAndView("login/login");
		login.addObject("user", new User());
		return login;
	}
	
	@RequestMapping(value="Register", method = RequestMethod.POST)
	public String createAcc(@ModelAttribute("user") User user) {
		this.userService.AddAccount(user); 
		return "redirect:Login";
	}
	
	@RequestMapping(value="Login", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") User user) {
		ModelAndView login = new ModelAndView("login/login");
		user =  userService.CheckAccount(user);
		if(user != null)
		{
			login.setViewName("redirect:/");
			session.setAttribute("LoginInfo", user);
			session.setAttribute("useradmin", user.getUsername());
		}
		else
		{
			login.addObject("statusLogin", "Đăng nhập thất bại");
		}		
		return login;
	} 
	
	@RequestMapping(value="Logout", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:"+request.getHeader("Referer");
	} 
}
