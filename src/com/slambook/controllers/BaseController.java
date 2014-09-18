package com.slambook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
	/*@Autowired
	RegisterService registerService;*/
	
	@RequestMapping("/")
	public String home(){
		//model.addAttribute("user", new UserDetails());
		return "index";
	}
	
	/*@RequestMapping("/register")
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
	}*/
}
