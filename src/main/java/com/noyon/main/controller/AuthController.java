package com.noyon.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.noyon.main.service.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;
	
	public AuthController (AuthService authService)
	{
		this.authService=authService;
	}
	
	
}
