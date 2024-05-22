package com.dinemaster.authService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dinemaster.enums.UserRole;
import com.dinemaster.models.SignupRequest;
import com.dinemaster.models.User;
import com.dinemaster.models.UserDto;
import com.dinemaster.repo.UserRepo;

@Service
public class AuthServiceImp implements AuthService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(SignupRequest signupRequest) {
		User user = new User();
		
		user.setName(signupRequest.getName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
		user.setUserRole(UserRole.CUSTOMER);
		User newUser = userRepo.save(user);
		
		UserDto userdto = new UserDto();
		userdto.setId(newUser.getId());
		userdto.setName(newUser.getName());
		userdto.setEmail(newUser.getEmail());
		userdto.setUserRoles(newUser.getUserRole());
		return userdto;
	}

}
