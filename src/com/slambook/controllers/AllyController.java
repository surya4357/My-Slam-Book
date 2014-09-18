package com.slambook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.slambook.models.FriendsDetails;
import com.slambook.models.UserDetails;
import com.slambook.service.AllyService;
import com.slambook.service.ModelService;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Hibernate;

@Controller
public class AllyController {
	
	@Autowired
	AllyService allyService;
	@Autowired
	ModelService modelService;
	
	@RequestMapping("/addAlly")
	public String addAlly(HttpServletRequest request, Model model){
		String message = "";
		if(allyService.addAlly(request.getParameter("ally_email")))
			message = "success";
		else
			message = "Already Exists";
		model.addAttribute("message", message);
		return "status";
	}
	
	@RequestMapping("/toSlamPage")
	public String toSlamPage(@RequestParam(value="user_email", required=false) String user_code,
			@RequestParam(value="friend_email", required=false) String friend_code,
			 Model model){
		String message = "";
		String destination = "";
		UserDetails user_details;
		FriendsDetails friend_details;
		
		try{
			String user_email = new String(Base64.decodeBase64(user_code.getBytes()));
			String friend_email = new String(Base64.decodeBase64(friend_code.getBytes()));		
			
			friend_details = modelService.getFriendDetails(friend_email);
			if(friend_details != null){
				destination = "shareSlamPage";
				model.addAttribute("friend_details", friend_details);
			}
			else{
				destination = "newSlamPage";
				model.addAttribute("friend_details", new FriendsDetails());
			}
			
			user_details = modelService.getUserDetails(user_email);
			if(user_details != null){
				model.addAttribute("user_name", user_details.getFname());
			}
			else
				destination = "error";
			
		}catch(Exception e){
			e.printStackTrace();
			destination = "error";
		}
		return destination;
	}
}
