package com.dinemaster.models;

import com.dinemaster.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {
	
    private Integer id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private UserRole userRoles;

}
