package com.shazhi.onlinestudy.controller;

import com.shazhi.onlinestudy.entity.UserEntity;
import com.shazhi.onlinestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    final
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("allUser")
    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }
}
