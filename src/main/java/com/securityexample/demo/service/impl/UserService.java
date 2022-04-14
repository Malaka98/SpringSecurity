package com.securityexample.demo.service.impl;

import com.securityexample.demo.entity.User;
import com.securityexample.demo.dto.RoleDTO;
import com.securityexample.demo.dto.UserDTO;
import com.securityexample.demo.repository.RoleRepository;
import com.securityexample.demo.repository.UserRepository;
import com.securityexample.demo.security.CustomUserDetails;
import com.securityexample.demo.util.DtoConverter;
import com.securityexample.demo.util.EntityConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements com.securityexample.demo.service.UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User found in the database");
        }

        return new CustomUserDetails(user);
    }

    @Override
    public void saveUser(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(DtoConverter.dtoToUser(user));
    }

    @Override
    public void saveRole(RoleDTO role) {
        roleRepository.save(DtoConverter.dtoToRole(role));
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserDTO user = EntityConverter.userToDto(userRepository.findByUsername(username));
        RoleDTO role = EntityConverter.roleToDto(roleRepository.findByName(roleName));
        user.getRole().add(DtoConverter.dtoToRole(role));
    }

    @Override
    public UserDTO getUser(String username) {
        return EntityConverter.userToDto(userRepository.findByUsername(username));
    }

    @Override
    public List<UserDTO> getUsers() {
        return EntityConverter.userToDto(userRepository.findAll());
    }

}
