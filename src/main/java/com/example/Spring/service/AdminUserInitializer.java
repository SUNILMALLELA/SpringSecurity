package com.example.Spring.service;

import com.example.Spring.entity.Role;
import com.example.Spring.entity.Users;
import com.example.Spring.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitializer {

    @Bean
    public CommandLineRunner createDefaultUsers(
            UserDetailsRepository userDetailsRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {
            if (userDetailsRepository.findByUsername("admin").isEmpty()) {

                Users admin = new Users();

                admin.setUsername("admin");

                admin.setPassword(
                        passwordEncoder.encode("admin1234")
                );
                admin.setRole(Role.ADMIN);
                userDetailsRepository.save(admin);

                System.out.println("Default ADMIN created");
            }
            if (userDetailsRepository.findByUsername("user").isEmpty()) {
                Users user = new Users();
                user.setUsername("user");
                user.setPassword(
                        passwordEncoder.encode("user1234")
                );

                user.setRole(Role.USER);
                userDetailsRepository.save(user);
                System.out.println("Default USER created");
            }
        };
    }
}