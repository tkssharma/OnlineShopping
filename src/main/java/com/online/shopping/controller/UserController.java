package com.online.shopping.controller;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.shopping.entity.User;
import com.online.shopping.service.UserService;



@Controller
public class UserController {

	@Autowired
	public UserService userServices;


	@ModelAttribute("user")
	public User ConstructUser()
	{
		return new User();
	}


	@RequestMapping("/index.html")
	public String ShowMain(Model model)
	{
		return "index";
	}


	@RequestMapping("/users")
	public String getUsers(Model model)
	{
		model.addAttribute("users", userServices.findAll());
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String getUsers(Model model , @PathVariable("id") int id)
	{
		model.addAttribute("user", userServices.findOnewithCartId(id));
		return "user-detail";
	}

	@RequestMapping(value = "/register.html")
	public String showRegister(Locale locale, Model model) {
		return "user-register";
	}

	@RequestMapping(value = "/register.html" , method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {

		userServices.save(user);
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping(value = "/login.html")
	public String login(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/account.html")
	public String getaccount(Model model , Principal principal) {
		model.addAttribute("user", userServices.findOnewithName(principal.getName()));
		return "user-account";
	}

}
