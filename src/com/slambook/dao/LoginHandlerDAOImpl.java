package com.slambook.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slambook.models.UserCredentials;

@Repository
@Transactional
public class LoginHandlerDAOImpl implements LoginHandlerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean handleLogin(String email, String password) {
		try{
			UserCredentials user_credentials = (UserCredentials) sessionFactory.getCurrentSession().load(UserCredentials.class, email);
		
			if(password.equals(user_credentials.getPassword())){
				return true;
			}
			else
				return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
