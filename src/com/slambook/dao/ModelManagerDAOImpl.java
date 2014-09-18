package com.slambook.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slambook.models.FriendsDetails;
import com.slambook.models.UserDetails;
import com.slambook.models.UserFriendsList;

@Repository
@Transactional
public class ModelManagerDAOImpl implements ModelManagerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public FriendsDetails getFriendDetails(String email) {
		FriendsDetails friends_details = null;
		try{
			friends_details = (FriendsDetails)sessionFactory.getCurrentSession().load(
					FriendsDetails.class, email); 
		}catch(Exception e){
			e.printStackTrace();
		}		
		return friends_details;
	}

	@Override
	public UserDetails getUserDetails(String email) {
		UserDetails user_details = null;
		try{
			user_details = (UserDetails)sessionFactory.getCurrentSession()
					.load(UserDetails.class, email);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return user_details;
	}

	@Override
	public UserFriendsList getUserFriendsList(String email) {
		UserFriendsList user_friends_list = null;
		try{
			user_friends_list = (UserFriendsList)sessionFactory.getCurrentSession()
					.load(UserFriendsList.class, email);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return user_friends_list;
	}

}
