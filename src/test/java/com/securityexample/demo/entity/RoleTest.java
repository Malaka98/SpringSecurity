package com.securityexample.demo.entity;

import com.securityexample.demo.dto.RoleDTO;
import com.securityexample.demo.dto.UserDTO;
import com.securityexample.demo.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;


@SpringBootTest
class RoleTest {
    @Autowired
    private UserService userService;

    @Test
    public void addRole() {

        userService.saveRole(RoleDTO.builder()
                .id(null)
                .name("ROLE_USER")
                .build());

        userService.saveRole(RoleDTO.builder()
                .id(null)
                .name("ROLE_MANAGER")
                .build());

        userService.saveRole(RoleDTO.builder()
                .id(null)
                .name("ROLE_ADMIN")
                .build());
    }

    @Test
    public void addUser() {

        userService.saveUser(UserDTO.builder()
                .id(null)
                .name("root")
                .username("root")
                .password("123")
                .role(new ArrayList<>())
                .build());

        userService.saveUser(UserDTO.builder()
                .id(null)
                .name("zuko")
                .username("zuko")
                .password("123")
                .role(new ArrayList<>())
                .build());
    }

    @Test
    public void addRoleToUser() {
        userService.addRoleToUser("root", "ROLE_ADMIN");
        userService.addRoleToUser("zuko", "ROLE_MANAGER");
        userService.addRoleToUser("zuko", "ROLE_ADMIN");
    }

}