package com.securityexample.demo;

import com.securityexample.demo.model.Role;
import com.securityexample.demo.model.User;
import com.securityexample.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "root", "root", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "zuko", "zuko", "123", new ArrayList<>()));

			userService.addRoleToUser("root", "ROLE_ADMIN");
			userService.addRoleToUser("zuko", "ROLE_MANAGER");
			userService.addRoleToUser("zuko", "ROLE_ADMIN");
		};
	}

}
