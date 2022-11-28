package com.tgi.springBanking.Entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrganisationRequestDto  {
	
	//private static final long serialVersionUID = 98765621564361L;

	private String orgName;
	private String mailId;
    private String orgType;
	private String phoneNumber;
	private List<Address> address;
	private Boolean status;
	


    
	

}
