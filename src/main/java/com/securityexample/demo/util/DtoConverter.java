package com.securityexample.demo.util;

import com.securityexample.demo.dto.RoleDTO;
import com.securityexample.demo.dto.UserDTO;
import com.securityexample.demo.entity.Role;
import com.securityexample.demo.entity.User;
import com.securityexample.demo.exception.UnknownException;

public class DtoConverter {

    public static User dtoToUser(UserDTO dto) {
        if(dto != null) {
            return User.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .username(dto.getUsername())
                    .password(dto.getPassword())
                    .role(dto.getRole())
                    .build();
        } else {
            throw new UnknownException(String.format("Unknown : %s entity\n", dto.getClass().getName()));
        }
    }

    public static Role dtoToRole(RoleDTO dto) {
        if(dto != null) {
            return Role.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .build();
        } else {
            throw new UnknownException(String.format("Unknown : %s entity\n", dto.getClass().getName()));
        }
    }

}
