package com.securityexample.demo.controller;

import com.securityexample.demo.AbstractTest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
    void saveUser() {
    }

    @Test
    void saveRole() {
    }

    @Test
    void saveRoleToUser() {
    }
}