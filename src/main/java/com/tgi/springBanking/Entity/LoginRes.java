package com.tgi.springBanking.Entity;

public class LoginRes {
	
	
	private final String jwt;
	
	
	public LoginRes(String jwt) {
		super();
		this.jwt = jwt;
	}


	public String getJwt() {
		return jwt;
	}

}
