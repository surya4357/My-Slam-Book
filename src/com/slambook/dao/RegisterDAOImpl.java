package com.slambook.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slambook.models.UserCredentials;
import com.slambook.models.UserDetails;
import com.slambook.models.UserFriendsList;

@Repository
@Transactional
public class RegisterDAOImpl implements RegisterDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetails user_details) {
		try{
			UserCredentials userCredentials = new UserCredentials();
			userCredentials.setEmail(user_details.getEmail());
			userCredentials.setPassword(user_details.getPassword());
			
			UserFriendsList userFriendsList = new UserFriendsList();
			userFriendsList.setEmail(user_details.getEmail());
			userFriendsList.setAlly_list(null);
			
			sessionFactory.getCurrentSession().save(user_details);
			sessionFactory.getCurrentSession().save(userCredentials);
			sessionFactory.getCurrentSession().save(userFriendsList);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
