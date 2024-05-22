package com.dinemaster.authService;

import com.dinemaster.models.SignupRequest;
import com.dinemaster.models.UserDto;

public interface AuthService {

	UserDto createUser(SignupRequest signupRequest);

}
