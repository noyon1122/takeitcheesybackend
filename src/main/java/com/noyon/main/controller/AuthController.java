package com.noyon.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noyon.main.dtos.SignupRequest;
import com.noyon.main.dtos.UserDto;
import com.noyon.main.service.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;
	
	public AuthController (AuthService authService)
	{
		this.authService=authService;
	}
	
	@GetMapping("/get")
	public String getSomething()
	
	{
		return "Hello there";
	}
	@PostMapping("/signup")
	public ResponseEntity<?> singupUser(@RequestBody SignupRequest signupRequest )
	{
	  UserDto createdUserDto=authService.createUser(signupRequest);
	if(createdUserDto==null)
	{
		  return new ResponseEntity<>("User not found ",HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}
	
	
}
