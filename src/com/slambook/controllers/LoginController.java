package com.slambook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.slambook.models.UserCredentials;
import com.slambook.service.LoginService;

@Controller
public class LoginController{
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("userCredentials", new UserCredentials());
		return "login";
	}
	
	@RequestMapping(value = "/loginHandler", method = RequestMethod.POST)
	public String loginHandler(@ModelAttribute("userCredentials") UserCredentials userCredentials, Model model, 
			HttpServletRequest request, HttpServletResponse response){
		String message = "";		
		if(loginService.handleLogin(userCredentials)){
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", userCredentials.getEmail());
			model.addAttribute("ally_email", new String());
			model.addAttribute("user", httpSession.getAttribute("user"));
			return "home";
		}
		else
			message = "failure";
		model.addAttribute("message", message);
		return "status";
	}
}
