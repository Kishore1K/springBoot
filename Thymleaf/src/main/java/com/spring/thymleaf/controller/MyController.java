package com.spring.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class MyController {

    @GetMapping("/about")
    public  String about(Model model){
        System.out.println("MyController.about");
        model.addAttribute("name", "Kishore");
        model.addAttribute("date", new Date().toString());
        return  "about";
    }
}
