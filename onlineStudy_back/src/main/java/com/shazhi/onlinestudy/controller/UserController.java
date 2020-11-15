package com.shazhi.onlinestudy.controller;

import com.shazhi.onlinestudy.entity.UserEntity;
import com.shazhi.onlinestudy.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("user/querySecuritiesByUsername")
    public Map<String,Object> querySecuritiesByUsername(@RequestBody UserEntity user){
        return userService.querySecuritiesByUsername(user);
    }

    @RequestMapping("user/getProfileByUsername")
    public UserEntity getProfileByUsername(@RequestBody UserEntity user){
        return userService.getProfileByUsername(user);
    }

}
