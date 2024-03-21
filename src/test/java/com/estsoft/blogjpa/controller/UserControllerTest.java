package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.User;
import com.estsoft.blogjpa.dto.AddUserRequest;
import com.estsoft.blogjpa.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc   //MockMvc 생성 및 구성
@SpringBootTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext ac;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void mockMvcSetup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ac).build();
    }

    @Test
    void signup() throws Exception {
        //given-when-then pattern 사용

        //given : 회원가입에 필요한 정보 초기화 해주기
        AddUserRequest addUserRequest = new AddUserRequest("test_email", "test_pw");
//        userRepository.save(new User(addUserRequest.getEmail(), addUserRequest.getPassword()));

        //when : 동작에 대한 검증, POST /user
        mockMvc.perform(post("/user")
                .param("email", "test_email")
                .param("password","test_pw"));

        //then : 호출 결과 HTTP Status code 로 검증 (200)
        User byEmail = userRepository.findByEmail(addUserRequest.getEmail()).orElseThrow();
        Assertions.assertNotNull(byEmail);
    }
}