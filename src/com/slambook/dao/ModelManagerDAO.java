package com.slambook.dao;

import com.slambook.models.FriendsDetails;
import com.slambook.models.UserDetails;
import com.slambook.models.UserFriendsList;

public interface ModelManagerDAO {
	public FriendsDetails getFriendDetails(String email);
	public UserDetails getUserDetails(String email);
	public UserFriendsList getUserFriendsList(String email);
}
