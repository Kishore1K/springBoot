package com.jwt.new1.Controller;

import com.jwt.new1.model.JwtToken;
import com.jwt.new1.model.LoginDTO;
import com.jwt.new1.Service.CustomUserDetailService;
import com.jwt.new1.helper.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody LoginDTO loginDTO) throws Exception {
        System.out.println("loginDTO = " + loginDTO);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User  Not Found");
        }

        UserDetails userDetails = customUserDetailService.loadUserByUsername(loginDTO.getUsername());

        String token = jwtUtil.generateToken(userDetails);
        return new ResponseEntity<>(new JwtToken(token), HttpStatus.OK);

    }
}
