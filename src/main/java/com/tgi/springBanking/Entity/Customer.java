package com.tgi.springBanking.Entity;

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
import com.vladmihalcea.hibernate.type.json.JsonBlobType;

@Entity
@Table(name = "customer")
@TypeDef(name = "jsonb", typeClass = JsonBlobType.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@NotBlank(message = "firstName is mandatory")
	@Column(name = "firstName")
	private String firstName;
	@NotBlank(message = "lastName is mandatory")
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "contactEmail")
	private String contactEmail;
	@Column(name = "contactNumber")
	private String contactNumber;
	@Column(name = "status")
	private boolean status;

	@Column(name = "address")
	@Type(type = "jsonb")
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_id", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Org_id",referencedColumnName="id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Organisation organisation;

	public Customer() {

	}


	public Customer(Long id, @NotBlank(message = "firstName is mandatory") String firstName,
			@NotBlank(message = "lastName is mandatory") String lastName, String contactEmail, String contactNumber,
			boolean status, Address address, User user, Organisation organisation) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactEmail = contactEmail;
		this.contactNumber = contactNumber;
		this.status = status;
		this.address = address;
		this.user = user;
		this.organisation = organisation;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
