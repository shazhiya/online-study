package com.shazhi.onlinestudy.service.imply;

import com.alibaba.fastjson.JSONObject;
import com.shazhi.onlinestudy.entity.RoleEntity;
import com.shazhi.onlinestudy.entity.UserEntity;
import com.shazhi.onlinestudy.repository.UserManagerRepository;
import com.shazhi.onlinestudy.service.UserManagerService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserManagerServiceImpl implements UserManagerService {
    final UserManagerRepository userManager;

    public UserManagerServiceImpl(UserManagerRepository userManager) {
        this.userManager = userManager;
    }


    @Override
    public Map<String, Object> userList(Integer start, Integer width, UserEntity query) {
        Map<String, Object> result = new HashMap<String,Object>();
        System.out.println(query);

        Page<UserEntity> page = userManager.findAll(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p = criteriaBuilder.like(root.get("userName"),'%'+query.getUserName() + '%');
                if (query.getUserEnable() != null) p = criteriaBuilder.and(p,criteriaBuilder.equal(root.get("userEnable"),query.getUserEnable()));
                if (query.getRoles().get(0).getRoleId()!=null) p = criteriaBuilder.and(p,criteriaBuilder.equal(root.join("roles", JoinType.INNER).get("roleId"),query.getRoles().get(0).getRoleId()));
                return criteriaQuery
                        .where(p)
                        .groupBy(root.get("userId"))
                        .getRestriction();
            }
        },PageRequest.of(start,width));

        result.put("totalPage",page.getTotalPages());
        result.put("totalUser",page.getTotalElements());
        result.put("userList",page.getContent().stream().map(UserEntity::ignoreAttr).collect(Collectors.toList()));


        return result;
    }

    @Override
    public Boolean update(UserEntity user) {
        try{
            userManager.save(userManager.findById(user.getUserId()).get()
                    .setUserHeadico(user.getUserHeadico()))
                    .setUserIntro(user.getUserIntro())
                    .setUserTelephone(user.getUserTelephone())
                    .setUserEmail(user.getUserEmail());
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
