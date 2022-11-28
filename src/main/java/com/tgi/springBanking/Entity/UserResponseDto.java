package com.tgi.springBanking.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserResponseDto  {
	//private static final long serialVersionUID = 179874654654L;
	private String userName;
	private String phoneNumber;
	private boolean  status;

}
