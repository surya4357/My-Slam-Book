package com.slambook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slambook.dao.LoginHandlerDAO;
import com.slambook.models.UserCredentials;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginHandlerDAO loginHandlerDAO;
	
	@Override
	public boolean handleLogin(UserCredentials userCredentials) {
		String email = userCredentials.getEmail();
		String password = userCredentials.getPassword();
		return loginHandlerDAO.handleLogin(email, password);
	}

}
