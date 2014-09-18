package com.slambook.service;

import com.slambook.models.FriendsDetails;
import com.slambook.models.UserDetails;
import com.slambook.models.UserFriendsList;

public interface ModelService {
	public FriendsDetails getFriendDetails(String email);
	public UserDetails getUserDetails(String email);
	public UserFriendsList getUserFriendsList(String email);
}
