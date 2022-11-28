package com.tgi.springBanking.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class StaffResponseDto implements Serializable {
private static final long serialVersionUID = 123456987L;
private Address address;
private String name;
private Long employeeCode;
private boolean status;
}
