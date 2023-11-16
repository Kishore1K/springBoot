package com.jwt.controller;

import com.jwt.Service.CustomUserDetailsService;
import com.jwt.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getPassword());
        return ResponseEntity.ok(userDetailsService.saveUser(userDTO));
    }
}
