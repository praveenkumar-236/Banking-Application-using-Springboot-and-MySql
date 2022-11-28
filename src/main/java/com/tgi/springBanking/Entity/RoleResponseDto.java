package com.tgi.springBanking.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class RoleResponseDto implements Serializable  {
//private static final long serialVersionUID = 123456789L;
private String roleName;
private String Access;
private boolean status;
}
