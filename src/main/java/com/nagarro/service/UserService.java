package com.nagarro.service;

import com.nagarro.dto.UserDto;
import com.nagarro.entity.User;

public interface UserService {

	User saveUser(User user);
	
	User fetchUserByEmailId(String emailId);
	
	Long countAllRegistrated();

	User registerUser(User user) throws Exception;


}
