package com.tgi.springBanking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "role")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
    @Column(name = "roleName")
	private String roleName;
	@Column(name = "Access")
	private String Access;
	@Column(name = "Status")
	private boolean status;
	

	public Role() {

	}
	
	


	public Role(Long id, String roleName, String access, boolean status) {
		super();
		this.id = id;
		this.roleName = roleName;
		Access = access;
		this.status = status;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getAccess() {
		return Access;
	}


	public void setAccess(String access) {
		Access = access;
	}


	public boolean getStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	


	




	
	


}
