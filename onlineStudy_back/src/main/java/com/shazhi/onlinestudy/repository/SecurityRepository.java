package com.shazhi.onlinestudy.repository;

import com.shazhi.onlinestudy.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<RoleEntity,Integer>, JpaSpecificationExecutor<RoleEntity> {
    @Modifying
    @Query(nativeQuery = true,value = "update online_study.user set user_enable = :userEnable where user_id = :userId")
    Integer setEnable(@Param("userEnable") Boolean userEnable,@Param("userId") Integer userId);
}
