package com.securityexample.demo.controller;

import com.securityexample.demo.AbstractTest;
import com.securityexample.demo.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserControllerTest extends AbstractTest {

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
    void getUsers() throws Exception {
        String uri = "/api/users";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        log.info("===========> " + content);
    }

    @Test
    void saveUser() throws Exception {
        String uri = "/api/user/save";

        String inputJson = super.mapToJson(UserDTO.builder()
                .id(null)
                .name("sanduni")
                .username("sanduni")
                .password("123")
                .role(new ArrayList<>())
                .build());

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        log.info("==========> " + content);
    }

    @Test
    void saveRole() {
    }

    @Test
    void saveRoleToUser() {
    }
}