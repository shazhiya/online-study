package com.shazhi.onlinestudy.service.imply;

import com.shazhi.onlinestudy.entity.UserEntity;
import com.shazhi.onlinestudy.repository.UserRepository;
import com.shazhi.onlinestudy.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Integer register(UserEntity registerUser) {
        try {
            registerUser = userRepository.save(registerUser);
            if (registerUser.getUserId() == null) return -1;
            else return 1;
        }catch (Exception exception){
            return -5;
        }
    }
}
