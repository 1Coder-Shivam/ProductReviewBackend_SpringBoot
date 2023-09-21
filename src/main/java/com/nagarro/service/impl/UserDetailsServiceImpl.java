package com.nagarro.service.impl;
import com.nagarro.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.nagarro.entity.User;
import com.nagarro.entity.CustomUserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserServiceImpl repository;

	@Override
	public CustomUserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		final User user=this.repository.fetchUserByEmailId(emailId);
		if(user==null) {
			return null;
		}
		else {
			return new CustomUserDetails(user);
		}
	}
}
