package com.slambook.service;

import com.slambook.models.FriendsDetails;

public interface AllyService {
	public boolean addAlly(String email);
	public boolean deleteAlly(String email);
	public String[] getAllyList();
	public boolean storeAlly(FriendsDetails friendsDetails);
	public boolean isAlly(String email);
	public boolean isAllyExist(String email);
}
