package com.slambook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slambook.dao.RegisterDAO;
import com.slambook.models.UserDetails;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	RegisterDAO registerDAO;
	
	@Override
	@Transactional
	public boolean registerUser(UserDetails user_details) {
		return registerDAO.registerUser(user_details);
	}

}
