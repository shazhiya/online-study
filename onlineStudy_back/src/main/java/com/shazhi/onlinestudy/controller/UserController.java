package com.shazhi.onlinestudy.controller;

import com.shazhi.onlinestudy.entity.UserEntity;
import com.shazhi.onlinestudy.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("allUser")
    public List<UserEntity> getAllUser(){
        return userService.findAll();
    }

    @RequestMapping("register")
    public Integer register(@RequestBody UserEntity registerUser){
        return userService.register(registerUser);
    }
}
