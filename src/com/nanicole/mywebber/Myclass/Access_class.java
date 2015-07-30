package com.nanicole.mywebber.Myclass;

public class Access_class {
	private String access_token;
	private String uid;
	public void access_token(String s){
		this.access_token=s;
	}
	public String access_token(){
		return this.access_token;
	}
	public void uid(String s){ 
		this.uid=s;
	}
	public String uid(){
		return this.uid;
	}

}
