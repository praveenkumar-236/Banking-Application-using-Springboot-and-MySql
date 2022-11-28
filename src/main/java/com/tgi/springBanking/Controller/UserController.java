package com.tgi.springBanking.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tgi.springBanking.Entity.LoginReq;
import com.tgi.springBanking.Entity.User;
import com.tgi.springBanking.Entity.UserRequestDto;
import com.tgi.springBanking.Entity.UserResponseDto;
import com.tgi.springBanking.Service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService Userservice;
	

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public List<UserResponseDto> getusers(@RequestHeader("Authorization")String authorization) {
		return Userservice.getusers();
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDto userDto) {
		return Userservice.createUser(userDto);
	}

	@RequestMapping(value = "/UserByid/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserByid(@PathVariable("id") Long id) {
		return Userservice.getUserByid(id);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserRequestDto userDto,Long id) {
		return Userservice.updateUser(userDto,id);
	}
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public ResponseEntity<?> Login(@RequestBody LoginReq loginReq)throws Exception{
		
		return Userservice.Login(loginReq);



	}
	@RequestMapping(value="/deleteUser/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?>deleteUser(@PathVariable("id") Long id){
		
		return Userservice.deleteUser(id);
	}
		
	}

	






