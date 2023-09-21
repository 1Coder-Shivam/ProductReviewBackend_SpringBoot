package com.nagarro.service.impl;

import com.nagarro.custom.exception.UserAlreadyExistsException;
import com.nagarro.entity.User;
import com.nagarro.mapper.UserMapper;
import com.nagarro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.nagarro.repository.RegistrationRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RegistrationRepository repo;
    @Autowired
    private UserServiceImpl service;

    @Autowired
    UserMapper mapper;

    @Override
    public User saveUser(User user) {
        return repo.save(user);
    }

    @Override
    public User fetchUserByEmailId(String emailId) {
        return repo.findByEmailId(emailId);
    }

    @Override
    public Long countAllRegistrated() {
        return repo.count();
    }

    @Override
    public User registerUser(User user) throws Exception {
        String tempEmailId = user.getEmailId();
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            User userObj = service.fetchUserByEmailId(tempEmailId);
            if (userObj != null) {
                throw new UserAlreadyExistsException("User with emailId " + tempEmailId + " already exists.");
            }
        }
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        User savedUser = service.saveUser(user);
        return savedUser;
    }


}
