package com.spring.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example {
    @GetMapping("/example")
    public  String example(){

        return  "example";

    }
}
