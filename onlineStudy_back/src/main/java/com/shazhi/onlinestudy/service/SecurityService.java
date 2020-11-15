package com.shazhi.onlinestudy.service;

import com.shazhi.onlinestudy.entity.RoleEntity;
import com.shazhi.onlinestudy.entity.UserEntity;

import java.util.List;

public interface SecurityService {
    List<RoleEntity> getAllRole();

    Boolean setUserEnable(UserEntity user);
}
