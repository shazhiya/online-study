package com.shazhi.onlinestudy.service;

import com.shazhi.onlinestudy.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserEntity> findAll();

    Integer register(UserEntity registerUser);

    Map<String, Object> querySecuritiesByUsername(UserEntity user);

    UserEntity getProfileByUsername(UserEntity user);
}
