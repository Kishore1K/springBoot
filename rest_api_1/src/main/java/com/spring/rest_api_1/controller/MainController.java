package com.spring.rest_api_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/home")
    public String home(){
        return "Home Page";
    }
    

    @GetMapping("/all")
    public String getAllBooks(){
        return "Hello Still in Development";
    }
}
