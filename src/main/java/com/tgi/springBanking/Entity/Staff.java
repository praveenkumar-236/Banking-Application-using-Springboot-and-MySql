package com.tgi.springBanking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBlobType;

@Entity
@Table(name = "staff")
@TypeDef(name = "jsonb", typeClass = JsonBlobType.class)
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// @NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;
	// @NotBlank(message = "employeeCode is mandatory")
	@Column(name = "employeeCode")
	private Long employeeCode;
	@Column(name = "address")
	@Type(type = "jsonb")
	private Address address;
	@Column(name = "status")
	private boolean status;

	public Staff() {

	}

	public Staff(Long id, String name, Long employeeCode, Address address, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.employeeCode = employeeCode;
		this.address = address;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
