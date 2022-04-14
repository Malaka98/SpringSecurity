package com.securityexample.demo.service;

import com.securityexample.demo.dto.RoleDTO;
import com.securityexample.demo.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO user);

    RoleDTO saveRole(RoleDTO role);

    void addRoleToUser(String username, String rolename);

    UserDTO getUser(String username);

    List<UserDTO> getUsers();
}
