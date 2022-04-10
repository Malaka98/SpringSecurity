package com.securityexample.demo.service;

import com.securityexample.demo.model.Role;
import com.securityexample.demo.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    User getUser(String username);

    List<User> getUsers();
}
