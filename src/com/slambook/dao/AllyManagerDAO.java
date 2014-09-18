package com.slambook.dao;

import com.slambook.models.FriendsDetails;

public interface AllyManagerDAO {
	public boolean addAlly(String email);
	public boolean deleteAlly(String email);
	public String[] getAllyList();
	public boolean storeAlly(FriendsDetails friendsDetails);
	public boolean isAlly(String email);
	public boolean isAllyExist(String email);
}
