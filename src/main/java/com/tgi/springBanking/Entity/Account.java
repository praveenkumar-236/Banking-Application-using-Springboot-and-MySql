package com.tgi.springBanking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tgi.springBanking.enums.AccountStatus;
import com.tgi.springBanking.enums.AccountType;

@Entity
@Table(name = "account")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "accountNo")
	private Long accountNo;
	@Column(name = "acctype")
	private String acctype;

	@Column(name = "runningbal")
	private Long runningbal;
	@Column(name = "previousbal")
	private Long previousbal;
	@Column(name = "actualbal")
	private Long actualbal;
	@Column(name = "amount")
	private Long amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "accountStatus")
	private AccountStatus accountStatus;

	public Account() {

	}
	
	
	
	
	
	
	
	

	public Account(Long id, Long accountNo, String acctype, Long runningbal, Long previousbal, Long actualbal,
			Long amount, AccountStatus accountStatus) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.acctype = acctype;
		this.runningbal = runningbal;
		this.previousbal = previousbal;
		this.actualbal = actualbal;
		this.amount = amount;
		this.accountStatus = accountStatus;
	}









	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public Long getRunningbal() {
		return runningbal;
	}

	public void setRunningbal(Long runningbal) {
		this.runningbal = runningbal;
	}

	public Long getPreviousbal() {
		return previousbal;
	}

	public void setPreviousbal(Long previousbal) {
		this.previousbal = previousbal;
	}

	public Long getActualbal() {
		return actualbal;
	}

	public void setActualbal(Long actualbal) {
		this.actualbal = actualbal;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
	
	
	









	
	
	
	
	
	
	
	

}
