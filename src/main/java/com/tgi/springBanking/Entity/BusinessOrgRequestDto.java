package com.tgi.springBanking.Entity;



import lombok.Data;

@Data
public class BusinessOrgRequestDto {
	
	private String orgName;
	private String orgType;
	private Boolean status;
	private String phoneNumber;
	private String contactEmail;
	private Address address;
}
