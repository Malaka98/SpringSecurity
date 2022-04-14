package com.securityexample.demo.util;

import com.securityexample.demo.dto.RoleDTO;
import com.securityexample.demo.dto.UserDTO;
import com.securityexample.demo.entity.Role;
import com.securityexample.demo.entity.User;
import com.securityexample.demo.exception.UnknownException;

import java.util.ArrayList;
import java.util.List;

public class EntityConverter {

    public static UserDTO userToDto(User entity) {
        if (entity != null) {
            return UserDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .username(entity.getUsername())
                    .password(entity.getPassword())
                    .role(entity.getRole())
                    .build();
        } else {
            throw new UnknownException(String.format("Unknown : %s entity\n", entity.getClass().getName()));
        }
    }

    public static List<UserDTO> userToDto(List<User> entity) {
        List<UserDTO> entityList = new ArrayList<>();

        for (User user : entity) {
            entityList.add(EntityConverter.userToDto(user));
        }

        return entityList;
    }

    public static RoleDTO roleToDto(Role entity) {
        if (entity != null) {
            return RoleDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();
        } else {
            throw new UnknownException(String.format("Unknown : %s entity\n", entity.getClass().getName()));
        }
    }

}
