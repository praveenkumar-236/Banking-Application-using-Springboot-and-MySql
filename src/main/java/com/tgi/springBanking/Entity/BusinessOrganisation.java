package com.tgi.springBanking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "BusinessOrganisation")
public class BusinessOrganisation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "orgName")
	private String orgName;
	@Column(name = "orgType")
	private String orgType;
	@Column(name = "status")
	private Boolean status;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@Column(name = "contactEmail")
	private String contactEmail;
	@Column(name = "address")
	@Type(type = "jsonb")
	private Address address;
	
	

	public BusinessOrganisation() {

	}

	public BusinessOrganisation(Long id, String orgName, String orgType, Boolean status, String phoneNumber,
			String contactEmail, Address address) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.orgType = orgType;
		this.status = status;
		this.phoneNumber = phoneNumber;
		this.contactEmail = contactEmail;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
