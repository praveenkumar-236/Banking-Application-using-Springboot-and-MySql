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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "user")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@NotBlank(message = "userName is mandatory")
	@Column(name = "userName")
	private String userName;
	@NotBlank(message = "password is mandatory")
	@Column(name = "password")
	private String password;
	@Column(name = "status")
	private boolean status;
	@Column(name = "phoneNumber")
	private String phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Role_id", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Role role;

	public User() {

	}

	public User(Long id, String userName, String password, boolean status, String phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
