package com.securityexample.demo.model;

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

        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_MANAGER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
    }

    @Test
    public void addUser() {
        userService.saveUser(new User(null, "root", "root", "123", new ArrayList<>()));
        userService.saveUser(new User(null, "zuko", "zuko", "123", new ArrayList<>()));
    }

    @Test
    public void addRoleToUser () {
        userService.addRoleToUser("root", "ROLE_ADMIN");
        userService.addRoleToUser("zuko", "ROLE_MANAGER");
        userService.addRoleToUser("zuko", "ROLE_ADMIN");
    }

}