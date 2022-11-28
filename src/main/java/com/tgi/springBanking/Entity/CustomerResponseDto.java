package com.tgi.springBanking.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerResponseDto  {
	

	private String firstName;
	private String lastName;
	private String contactEmail;
	private String contactNumber;
	private Address address;
	private boolean status;

	
	


	
	
	


}
