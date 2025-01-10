package com.noyon.main.service.auth;

import com.noyon.main.dtos.SignupRequest;
import com.noyon.main.dtos.UserDto;


public interface AuthService {

	UserDto createUser(SignupRequest singnupRequest);
}
