package com.tgi.springBanking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springBanking.Entity.Role;
import com.tgi.springBanking.Entity.RoleRequestDto;
import com.tgi.springBanking.Entity.RoleResponseDto;
import com.tgi.springBanking.Service.RoleService;



@RestController
@RequestMapping("/Role")
public class RoleController {
	@Autowired
	RoleService Roleservice;
	
	@RequestMapping(value="/getRole",method=RequestMethod.GET)
	public List<RoleResponseDto> getAllRole() {
		return Roleservice.getAll();
	}
	@RequestMapping(value="/createRole",method=RequestMethod.POST)
	public ResponseEntity<?> createRole(@RequestBody RoleRequestDto roleDto) {
		return Roleservice.createRole(roleDto);
	}
	@RequestMapping(value="/RoleById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getRoleById(@PathVariable("id")Long id) {
		return Roleservice.getRoleByid(id);
	}
	@RequestMapping(value="/updateRole",method=RequestMethod.PUT)
    public ResponseEntity<?> updateRole(@RequestBody RoleRequestDto roleDto,Long id) {
		return Roleservice.updateRole(roleDto,id);
	}
	@RequestMapping(value="/deleteRole/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?>deleteRole(@PathVariable("id")Long id){
		return Roleservice.deleteRole(id);
	}
	
	
}
