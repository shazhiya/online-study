package com.shazhi.onlinestudy.service;

import com.alibaba.fastjson.JSONObject;
import com.shazhi.onlinestudy.entity.UserEntity;

import java.util.Map;

public interface UserManagerService {
    Map<String, Object> userList(Integer start, Integer width, UserEntity query);

    Boolean update(UserEntity user);
}
