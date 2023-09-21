package com.nagarro.controller;

import com.nagarro.dto.UserDto;
import com.nagarro.entity.User;
import com.nagarro.mapper.UserMapper;
import com.nagarro.service.UserService;
import com.nagarro.service.impl.UserServiceImpl;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        User savedUser =userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

}

