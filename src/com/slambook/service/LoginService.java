package com.slambook.service;

import com.slambook.models.UserCredentials;

public interface LoginService {
	public boolean handleLogin(UserCredentials userCredentials);
}
