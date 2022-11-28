package com.tgi.springBanking.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springBanking.Entity.Role;
import com.tgi.springBanking.Entity.RoleRequestDto;
import com.tgi.springBanking.Entity.RoleResponseDto;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.RoleRepository;
import com.tgi.springBanking.enums.RoleStatus;


@Service
public class RoleServiceimpl implements RoleService {
     
	@Autowired
	RoleRepository Rolerepository;
	
	
	@Override
	public List<RoleResponseDto> getAll() {
		
		List<Role>role=Rolerepository.findAllByStatus(RoleStatus.ActiveStatus);
		List<RoleResponseDto> RoleList = new ArrayList<RoleResponseDto>(role.size());
		   for(Role u:role) {
			   RoleList.add( addRoletoRoleDto( u ) );
		    }
		return RoleList;
	}
	@Override
	public RoleResponseDto addRoletoRoleDto(Role role) {
		RoleResponseDto roleResponseDto=new RoleResponseDto();
		roleResponseDto.setAccess(role.getAccess());
		roleResponseDto.setRoleName(role.getRoleName());
		roleResponseDto.setStatus(role.getStatus());
		
		return roleResponseDto;
	}
	@Override
	public ResponseEntity<?> createRole(RoleRequestDto roleDto) {
		Role role=Rolerepository.findByroleName(roleDto.getRoleName());
		if(role!=null) {
			return new ResponseEntity("roleName is already exist",HttpStatus.OK);
		}
		
		Role role1=new Role();
		
		role1.setAccess(roleDto.getAccess());
		role1.setRoleName(roleDto.getRoleName());
		role1.setStatus(true);
		role1=Rolerepository.save(role1);
		//role.se
		RoleResponseDto roleResponseDto=new RoleResponseDto();
		roleResponseDto.setAccess(role1.getAccess());
		roleResponseDto.setRoleName(role1.getRoleName());
		roleResponseDto.setStatus(role1.getStatus());
	       
		return new ResponseEntity(roleResponseDto,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> getRoleByid(Long id) {
		Role role=Rolerepository.findByIdAndStatus(id,RoleStatus.ActiveStatus)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found this id "));
		
		return new ResponseEntity(role,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> updateRole(RoleRequestDto roleDto,Long id) {
		

		//id validation
		Role role=Rolerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found this id :"+id));
		//Dto 
		role.setAccess(roleDto.getAccess());
		role.setRoleName(roleDto.getRoleName());
		role.setStatus(roleDto.getStatus());
		Rolerepository.save(role);
		 return new ResponseEntity(roleDto,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> deleteRole(Long id) {
		Role role=Rolerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role delete id Not found :"+id));
		Rolerepository.delete(role);
		 return new ResponseEntity(role,HttpStatus.OK);
	}
	
	

}
