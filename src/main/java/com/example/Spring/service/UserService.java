package com.example.Spring.service;

import com.example.Spring.entity.RegisterUserRequest;
import com.example.Spring.entity.UserResponse;
import com.example.Spring.entity.Users;
import com.example.Spring.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
        //Check Username is exist or not
        if(userDetailsRepository.findByUsername(registerUserRequest.getUsername()).isPresent()){
            throw new RuntimeException("User already exist");
        }
        //encode password from request
        Users users = new Users();
        users.setUsername(registerUserRequest.getUsername());
        users.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        users.setRole(registerUserRequest.getRole());
        //save
        Users savedUser = userDetailsRepository.save(users);
        return new UserResponse(savedUser.getId(),savedUser.getUsername(),savedUser.getRole().name());



    }
}
