package com.tgi.springBanking.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springBanking.Entity.LoginReq;
import com.tgi.springBanking.Entity.User;
import com.tgi.springBanking.Entity.UserRequestDto;
import com.tgi.springBanking.Entity.UserResponseDto;


public interface UserService {
	
	

	public List<UserResponseDto> getusers();

	public  ResponseEntity<?> createUser(UserRequestDto userDto);

	public ResponseEntity<?> getUserByid(Long id);

	public ResponseEntity<?> updateUser(UserRequestDto user,Long id);

    public ResponseEntity<?> Login(LoginReq loginReq)throws Exception;

	 public UserResponseDto addUsertoUserDto(User user);

	public ResponseEntity<?> deleteUser(Long id);







	

}
