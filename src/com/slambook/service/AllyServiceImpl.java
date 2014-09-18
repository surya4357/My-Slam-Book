package com.slambook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slambook.dao.AllyManagerDAO;
import com.slambook.models.FriendsDetails;

@Service
public class AllyServiceImpl implements AllyService{

	@Autowired
	AllyManagerDAO allyManagerDAO;
	
	@Override
	public boolean addAlly(String email) {
		return allyManagerDAO.addAlly(email);
	}

	@Override
	public boolean deleteAlly(String email) {
		return allyManagerDAO.deleteAlly(email);
	}

	@Override
	public String[] getAllyList() {
		return allyManagerDAO.getAllyList();
	}

	@Override
	public boolean storeAlly(FriendsDetails friendsDetails) {
		return allyManagerDAO.storeAlly(friendsDetails);
	}

	@Override
	public boolean isAlly(String email) {
		return allyManagerDAO.isAlly(email);
	}

	@Override
	public boolean isAllyExist(String email) {
		return allyManagerDAO.isAllyExist(email);
	}

}
