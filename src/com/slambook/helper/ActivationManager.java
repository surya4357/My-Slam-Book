package com.slambook.helper;

import java.net.URI;
import java.security.MessageDigest;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.utils.URIBuilder;

public class ActivationManager {
	String from = "bujji.surya1555@gmail.com";
	String password = "dell1555";
	String host = "smtp.gmail.com";
	
	public boolean sendSlamLink(String user_email, String friend_email){
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", password);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		
		String content = getLinkCode(user_email, friend_email);
		
		try{
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(friend_email));
			message.setSubject("Slam Link");
			message.setContent(content, "text/html");
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public String getLinkCode(String user_email, String friend_email){
		String code = "";
		URI url = null;
		try{
			//MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] usercode = Base64.encodeBase64(user_email.getBytes());
			byte[] friendcode = Base64.encodeBase64(friend_email.getBytes());
			String encodedUserCode = new String(usercode);
			String encodedFriendCode = new String(friendcode);
			
			System.out.println(encodedUserCode);
			System.out.println(encodedFriendCode);
			
			//System.out.println(Base64.decodeBase64(encodedUserCode.getBytes()));
			//System.out.println(Base64.decodeBase64(encodedFriendCode.getBytes()));
			
			URIBuilder uri = new URIBuilder(); 
			uri.setScheme("http").setHost("localhost:8080").setPath("/MySlamBook/toSlamPage")
			.addParameter("user_email", encodedUserCode)
			.addParameter("friend_email", encodedFriendCode);
			url = uri.build();
			
			System.out.println(url);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return String.valueOf(url);
	}
	
	/*public static void main(String args[]){
		ActivationManager am = new ActivationManager();
		am.sendSlamLink("bujji.surya1555@gmail.com","surya.sovereign@gmail.com");
	}*/
}
