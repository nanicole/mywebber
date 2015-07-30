package com.nanicole.mywebber.Myclass;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserSerializable implements Serializable{
	private User user;
	public void set_user(User u){
		this.user=u;
	}
	public User get_user(){
		return user;
	}
	public UserSerializable(User u){
		this.user=u;
	}

}
