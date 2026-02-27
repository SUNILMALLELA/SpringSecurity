package com.example.Spring.controller;

import com.example.Spring.Utility.JWTUtil;
import com.example.Spring.entity.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping("/authenticate")
    public String GenerateToken(@RequestBody AuthRequest authRequest){
      try {
          authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
          );
          return jwtUtil.jwtUtilGenerateToken(authRequest.getUsername());

      } catch (Exception e) {
          throw new RuntimeException(e);
      }

    }

}
