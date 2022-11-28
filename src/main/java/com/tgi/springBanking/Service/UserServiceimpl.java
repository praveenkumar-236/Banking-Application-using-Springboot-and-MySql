package com.tgi.springBanking.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tgi.springBanking.Entity.LoginReq;
import com.tgi.springBanking.Entity.LoginRes;
import com.tgi.springBanking.Entity.User;
import com.tgi.springBanking.Entity.UserRequestDto;
import com.tgi.springBanking.Entity.UserResponseDto;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.RoleRepository;
import com.tgi.springBanking.Repository.UserRepository;
import com.tgi.springBanking.Utility.ValidatorUtil;
import com.tgi.springBanking.config.JwtUtil;
import com.tgi.springBanking.enums.UserStatus;

@Service
public class UserServiceimpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceimpl.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	private String String;
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	CustomUserDetailsService userDetailsService;
	@Autowired
	JwtUtil jwtTokenUtil;

	@Override
	public List<UserResponseDto> getusers() {
        List<User> user=userRepository.findAllByStatus(UserStatus.ActiveStatus);
		List<UserResponseDto> UserList = new ArrayList<UserResponseDto>(user.size());
		for ( User u : user ) {
			UserList.add( addUsertoUserDto( u ) );
        }
		
		logger.info("getAll users from userResponseDto operation management");
		
		return UserList;
	}

	@Override
	public ResponseEntity<?> createUser(UserRequestDto userDto) {
		//
		//user.setPassword(encoder.encode(user.getPassword()));

		User usvalidation = userRepository.findByuserName(userDto.getUserName());
		if (usvalidation != null) {
			return new ResponseEntity("MailId already exist", HttpStatus.BAD_REQUEST);
		}
		boolean phonevalid=ValidatorUtil.PhoneNumberIsValid(userDto.getPhoneNumber());
		if(phonevalid){
			System.out.println(phonevalid+" "+"phonenumbervalid");
		}else {
			System.out.println(phonevalid+" "+"phonenumberinvalid");
			Map<String, Object> response = new HashMap<>();
			response.put("messgee", "phonenumberis invalid");
			response.put("ErrorCode", HttpStatus.BAD_REQUEST);
			logger.info("phoneNumber is invalid");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		boolean valid = ValidatorUtil.EmailIsValid(userDto.getUserName());
		if (valid) {
			System.out.println(valid + " " + " Email id valid");
		
		} else {
			System.out.println(valid + " " + " Email id is not valid");
			Map<String, Object> response = new HashMap<>();
			response.put("messgee", "Invalid emailid");
			response.put("ErrorCode", HttpStatus.BAD_REQUEST);
			logger.info("EmailId is invalid");
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

			// return new ResponseEntity(user,HttpStatus.EXPECTATION_FAILED);
		}
		User user=new User();
	//	user.setId(userDto.getId());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setPassword(encoder.encode(userDto.getPassword()));
		//user.setRole(roleRepository.getById(userDto.getRoleId()));
		user.setUserName(userDto.getUserName());
		user.setStatus(true);
		user=userRepository.save(user);
		
		UserResponseDto userResponseDto=new UserResponseDto();
		userResponseDto.setPhoneNumber(user.getPhoneNumber());
		userResponseDto.setUserName(user.getUserName());
		userResponseDto.setStatus(user.getStatus());
		
		
		
		logger.info("userCreation management successfully");
		return new ResponseEntity(userResponseDto, HttpStatus.OK);
	}



	@Override
	public ResponseEntity<?> getUserByid(Long id) {
		
		User user=userRepository.findByIdAndStatus(id,UserStatus.ActiveStatus)
				.orElseThrow(() -> new ResourceNotFoundException(" user id not found :"+id));
				
		
		logger.info("getUserByid and activeStatus successfully ");
		return new ResponseEntity(user,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateUser(UserRequestDto userDto,Long id) {
		//validation 
//		Role role=roleRepository.findById(userDto.getRoleId())
//				.orElseThrow(() -> new ResourceNotFoundException(" user  id not found :"+id));
//	

		boolean phonevalid=ValidatorUtil.PhoneNumberIsValid(userDto.getPhoneNumber());
		if(phonevalid){
			System.out.println(phonevalid+" "+"phonenumbervalid");
		}else {
			System.out.println(phonevalid+" "+"phonenumberinvalid");
			Map<String, Object> response = new HashMap<>();
			response.put("messgee", "phonenumberis invalid");
			response.put("ErrorCode", HttpStatus.BAD_REQUEST);
			logger.info("updateUser phone numberis invalid  ");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		
		User user=userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" user id not found :"+id));
			
			user.setPhoneNumber(userDto.getPhoneNumber());
			user.setPassword(encoder.encode(userDto.getPassword()));
			user.setUserName(userDto.getUserName());
			user.setStatus(userDto.getStatus());

			userRepository.save(user);

		return new ResponseEntity(user,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> Login(LoginReq loginReq) throws Exception {
      try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginReq.getUserName(),loginReq.getPassword()));
      }catch(BadCredentialsException e) {
      	throw new Exception("incorrect username and password",e);
      }
	
      UserDetails userDetails=userDetailsService.loadUserByUsername(loginReq.getUserName());
	    String jwt=jwtTokenUtil.generateToken(userDetails);
	    return ResponseEntity.ok(new LoginRes(jwt));
	
	
	
	}
	@Override
	public UserResponseDto addUsertoUserDto(User user) {
		
		UserResponseDto userResponseDto=new UserResponseDto();
		userResponseDto.setPhoneNumber(user.getPhoneNumber());
		userResponseDto.setUserName(user.getUserName());
		userResponseDto.setStatus(user.getStatus());
		logger.info("addUsertoUserDto management successfully");
		
		return userResponseDto;
	}

	@Override
	public ResponseEntity<?> deleteUser(Long id) {
		
	User user=userRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException(" user id not exist with this id :"+id));
	
	       userRepository.delete(user);
           
	       logger.info("deleteUser id successfully");
		return new ResponseEntity(user,HttpStatus.OK);
	}
		
	

	

}
