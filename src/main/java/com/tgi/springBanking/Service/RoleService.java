package com.tgi.springBanking.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springBanking.Entity.Role;
import com.tgi.springBanking.Entity.RoleRequestDto;
import com.tgi.springBanking.Entity.RoleResponseDto;



public interface RoleService {

	public List<RoleResponseDto> getAll();

	public ResponseEntity<?> createRole(RoleRequestDto roleDto);

	public ResponseEntity<?> getRoleByid(Long id);

	public ResponseEntity<?> updateRole(RoleRequestDto roleDto,Long id);

	RoleResponseDto addRoletoRoleDto(Role role);

	public ResponseEntity<?> deleteRole(Long id);

}
