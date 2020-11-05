package com.shazhi.onlinestudy;

import com.alibaba.fastjson.support.jaxrs.FastJsonProvider;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.shazhi.onlinestudy.repository.UserRepository;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class OnlineStudyApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
//        System.out.println(FastJsonProvider);
    }

}
