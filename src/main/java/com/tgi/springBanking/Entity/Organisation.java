package com.tgi.springBanking.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vladmihalcea.hibernate.type.json.JsonBlobType;

@Entity
@Table(name = "Organisation")
@TypeDef(name = "jsonb", typeClass = JsonBlobType.class)
@JsonInclude(JsonInclude.Include.ALWAYS)
 public class Organisation  {
	
//	private static final long serialVersionUID = 1478655464561L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
//	@NotBlank(message = "orgCode is mandatory")
	@Column(name = "orgCode")
	private Long orgCode;
	@NotBlank(message = "orgName is mandatory")
	@Column(name = "orgName")
	private String orgName;
	@Column(name = "mailId")
	private String mailId;
//	@NotBlank(message = "phoneNumber is mandatory")
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@NotBlank(message = "orgType is mandatory")
	@Column(name = "orgType")
	private String orgType;
	@Column(name="status")
	private boolean status;
	@Column(name = "address")
	@Type(type = "jsonb")
    private List<Address> address;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Account_id", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Account account;

	public Organisation() {

	}

	public Organisation(Long id, Long orgCode, String orgName, String mailId, String phoneNumber, String orgType,boolean status) {
		super();
		this.id = id;
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.mailId = mailId;
		this.phoneNumber = phoneNumber;
		this.orgType = orgType;
		this.status=status;
		
	}
	
	



	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(Long orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
	

}
