package com.slambook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.slambook.models.UserDetails;
import com.slambook.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("/register")
	public String register(Model model){
		model.addAttribute("user", new UserDetails());
		return "register";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") UserDetails userDetails, Model model){
		String message = "";
		if(registerService.registerUser(userDetails))
			message = "success";
		else
			message = "failure";
		model.addAttribute("message", message);
		return "status";
	}
}
