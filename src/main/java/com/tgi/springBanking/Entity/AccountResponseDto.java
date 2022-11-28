package com.tgi.springBanking.Entity;

import java.io.Serializable;

import com.tgi.springBanking.enums.AccountStatus;

import lombok.Data;

@Data
public class AccountResponseDto {
	//private static final long serialVersionUID = 123456789L;
	
	
	private Long accountNo;
	private String acctype;
    private Long Previousbal;
    private Long Actualbal;
    private Long runningbal;
    private Long Amount;
	private AccountStatus accountStatus;
	public void setAccountNo(String string) {
		// TODO Auto-generated method stub
		
	}

}
