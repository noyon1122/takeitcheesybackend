package com.noyon.main.service.auth;

import java.net.PasswordAuthentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.noyon.main.dtos.SignupRequest;
import com.noyon.main.dtos.UserDto;
import com.noyon.main.entities.User;
import com.noyon.main.enums.UserRole;
import com.noyon.main.repository.UserRepository;

@Service

public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;

	
	

	public AuthServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		
	}
	



	@Override
	public UserDto createUser(SignupRequest singnupRequest) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName(singnupRequest.getName());
		user.setEmail(singnupRequest.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(singnupRequest.getPassword()));
		user.setUserRole(UserRole.CUSTOMER);
	 User createdUser=userRepository.save(user);
	 UserDto createdUserDto=new UserDto();
	 createdUserDto.setId(createdUser.getId());
	 createdUserDto.setName(createdUser.getName());
	 createdUserDto.setEmail(createdUser.getEmail());
	 createdUserDto.setUserRole(createdUser.getUserRole());
		return createdUserDto;
	}

}
