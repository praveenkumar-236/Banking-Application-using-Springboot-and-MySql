package com.tgi.springBanking.Entity;



import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserRequestDto    {
	//private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "userName is mandatory")
	private String userName;
	@NotBlank(message = "password is mandatory")
	private String password;
	private String phoneNumber;
	private Boolean status;


	
	
	

}
