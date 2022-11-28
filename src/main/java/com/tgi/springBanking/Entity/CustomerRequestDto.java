package com.tgi.springBanking.Entity;



import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerRequestDto   {
	//private static final long serialVersionUID = -7157547015793301184L;
	
	
	private String firstName;
	private String lastName;
	private String contactEmail;
	private String contactNumber;
	private Address address;
	private Boolean status;


	
	
	

	


	
	


}
