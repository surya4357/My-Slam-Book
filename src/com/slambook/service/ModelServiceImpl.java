package com.slambook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slambook.dao.ModelManagerDAO;
import com.slambook.models.FriendsDetails;
import com.slambook.models.UserDetails;
import com.slambook.models.UserFriendsList;

@Service
public class ModelServiceImpl implements ModelService{

	@Autowired
	ModelManagerDAO model_manager;
	
	@Override
	public FriendsDetails getFriendDetails(String email) {
		return model_manager.getFriendDetails(email);
	}

	@Override
	public UserDetails getUserDetails(String email) {
		return model_manager.getUserDetails(email);
	}

	@Override
	public UserFriendsList getUserFriendsList(String email) {
		return model_manager.getUserFriendsList(email);
	}

}
