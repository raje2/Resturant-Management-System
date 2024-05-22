package com.dinemaster.authController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinemaster.authService.AuthService;
import com.dinemaster.models.SignupRequest;
import com.dinemaster.models.UserDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
	  UserDto createdUser =	authService.createUser(signupRequest);
	  
	  if(createdUser == null) {
		  return new ResponseEntity<>("User Not Created. Try Again", HttpStatus.BAD_REQUEST);
	  }else {
		  return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	  }
	}
	
	

}
