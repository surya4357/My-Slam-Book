package com.slambook.dao;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.slambook.helper.ActivationManager;
import com.slambook.models.FriendsDetails;
import com.slambook.models.UserFriendsList;

@Repository
@Transactional
public class AllyManagerDAOImpl implements AllyManagerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	ServletRequestAttributes requestAttributes;
	HttpSession httpSession;
	
	/*public AllyManagerDAOImpl(){
		requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		httpSession = requestAttributes.getRequest().getSession();
	}*/
	
	@Override
	public boolean addAlly(String email) {
			if(!isAlly(email)){
				sendActivationLink(email);
				return true;
			}			
			return false;
	}

	@Override
	public boolean deleteAlly(String email) {
		return false;
	}

	@Override
	public String[] getAllyList() {
		return null;
	}

	@Override
	public boolean storeAlly(FriendsDetails friendsDetails) {
		try{
			sessionFactory.getCurrentSession().save(friendsDetails);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isAlly(String email) {
		requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		httpSession = requestAttributes.getRequest().getSession();
		String user_email = (String) httpSession.getAttribute("user");
		
		try{
			UserFriendsList userFriendsList = (UserFriendsList) sessionFactory.getCurrentSession()
				.load(UserFriendsList.class, user_email);
			
			Blob blob_list = userFriendsList.getAlly_list();
			if(blob_list != null){
				byte[] raw_list = blob_list.getBytes(1, (int)blob_list.length());
				ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(raw_list));
				String[] friends_list = (String[]) ois.readObject();
				
				for(String friend_email:friends_list) {
					if(friend_email.equals(email))
						return true;
				}
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isAllyExist(String email) {
		if((FriendsDetails) sessionFactory.getCurrentSession().load(FriendsDetails.class, email) != null)
			return true;
		return false;
	}
	
	public void sendActivationLink(String email){
		requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		httpSession = requestAttributes.getRequest().getSession();
		ActivationManager activationManager = new ActivationManager();
		activationManager.sendSlamLink((String) httpSession.getAttribute("user"), email);
	}
}
