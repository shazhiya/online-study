package com.shazhi.onlinestudy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shazhi.onlinestudy.entity.UserEntity;
import com.shazhi.onlinestudy.service.UserManagerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@RestController
@Transactional
public class UserManagerController {

    final UserManagerService userManagerService;

    public UserManagerController(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @RequestMapping("user/list")
    public Map<String, Object> userList(Integer start, Integer width,String query){
        return userManagerService.userList(start,width,JSONObject.parseObject(query, UserEntity.class));
    }

    @RequestMapping("user/update")
    public Boolean update(@RequestBody UserEntity user){
        return userManagerService.update(user);
    }
}
