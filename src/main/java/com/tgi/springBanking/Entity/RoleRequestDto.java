package com.tgi.springBanking.Entity;



import java.io.Serializable;

import lombok.Data;

@Data
public class RoleRequestDto  {
	//private static final long serialVersionUID = 1L;
	
	private String roleName;
	private String Access;
	private Boolean status;
	

}
