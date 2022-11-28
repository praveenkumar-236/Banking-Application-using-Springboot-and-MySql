package com.tgi.springBanking.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class StaffRequestDto  {
	//private static final long serialVersionUID = 123456789L;
	
	private String name;
	private Long employeeCode;
	private Address address;
	private Boolean status;
	
	

}
