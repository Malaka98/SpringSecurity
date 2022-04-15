package com.securityexample.demo.dto;

import com.securityexample.demo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    @NotEmpty
    private String name;
    private String username;
    private String password;
    private Collection<Role> role = new ArrayList<>();
}
