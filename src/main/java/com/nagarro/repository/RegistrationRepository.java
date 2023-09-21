package com.nagarro.repository;

import com.nagarro.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.entity.User;
@Repository
public interface RegistrationRepository extends JpaRepository<User,Integer>{
    
	User findByEmailId(String emailId);
    User findByEmailIdAndPassword(String emailId,String password);
}
