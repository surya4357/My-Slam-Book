package com.slambook.models;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="FRIENDS_LIST")
public class UserFriendsList {
	private String email;
	//private String ally_list;
	private Blob ally_list;
	
	@Id
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*@Column(name="ally_list")
	public String getAlly_list() {
		return ally_list;
	}
	public void setAlly_list(String ally_list) {
		this.ally_list = ally_list;
	}*/
	
	@Column(name="ALLY_LIST")
	@Lob
	public Blob getAlly_list() {
		return ally_list;
	}
	public void setAlly_list(Blob ally_list) {
		this.ally_list = ally_list;
	}
}
