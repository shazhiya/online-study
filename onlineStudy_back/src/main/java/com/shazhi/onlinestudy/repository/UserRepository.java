package com.shazhi.onlinestudy.repository;

import com.shazhi.onlinestudy.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;


public interface UserRepository extends JpaRepository<UserEntity,Integer> , JpaSpecificationExecutor<UserEntity>, Serializable {
    UserEntity getUserEntityByUserName(String userName);

    @Query("select user from UserEntity user where user.userName = :username")
    UserEntity getProfileByUsername(@Param("username") String username);

}
