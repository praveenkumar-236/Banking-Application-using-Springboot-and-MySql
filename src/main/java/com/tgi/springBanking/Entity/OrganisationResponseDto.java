package com.tgi.springBanking.Entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class OrganisationResponseDto {


	private String orgName;
	private String mailId;
	private String orgType;
	private String phoneNumber;
	private List<Address> address;
	private boolean status;
	
	
	

	
	

}
