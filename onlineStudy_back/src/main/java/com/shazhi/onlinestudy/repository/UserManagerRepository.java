package com.shazhi.onlinestudy.repository;

import com.shazhi.onlinestudy.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.io.Serializable;

public interface UserManagerRepository extends JpaRepository<UserEntity,Integer>, JpaSpecificationExecutor<UserEntity>, Serializable {

}
