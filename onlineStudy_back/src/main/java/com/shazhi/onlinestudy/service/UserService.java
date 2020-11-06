package com.shazhi.onlinestudy.service;

import com.shazhi.onlinestudy.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();
    Integer register(UserEntity registerUser);
}
