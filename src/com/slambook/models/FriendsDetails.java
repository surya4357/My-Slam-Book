package com.slambook.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRIENDS_DETAILS")
public class FriendsDetails {
	private String email;
	private String name;
	private String nick_name;
	private String fav_person;
	
	@Id
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="NICK_NAME")
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	
	@Column(name="FAV_PERSON")
	public String getFav_person() {
		return fav_person;
	}
	public void setFav_person(String fav_person) {
		this.fav_person = fav_person;
	}
		
}
