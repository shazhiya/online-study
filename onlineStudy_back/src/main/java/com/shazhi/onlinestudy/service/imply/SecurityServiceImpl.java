package com.shazhi.onlinestudy.service.imply;

import com.shazhi.onlinestudy.entity.RoleEntity;
import com.shazhi.onlinestudy.entity.UserEntity;
import com.shazhi.onlinestudy.repository.SecurityRepository;
import com.shazhi.onlinestudy.service.SecurityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityServiceImpl implements SecurityService {
    final
    SecurityRepository securityRepository;

    public SecurityServiceImpl(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @Override
    public List<RoleEntity> getAllRole() {
        return securityRepository
                .findAll()
                .stream()
                .map(RoleEntity::ignoreAttr)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean setUserEnable(UserEntity user) {
        return securityRepository.setEnable(user.getUserEnable(), user.getUserId()) == 1;
    }
}
