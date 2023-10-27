package com.spring.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("/about")
    public  String about(Model model){
        System.out.println("MyController.about");
        model.addAttribute("name", "Kishore");
        model.addAttribute("date", new Date().toString());
        return  "about";
    }


//    handling for iteration
    @GetMapping("/loop")
    public  String iterateHandler(Model m){
        List<String> names= List.of("Kishore", "Reddy", "Karthick","Ankush", "Manju");
        m.addAttribute("names", names);
        return  "iterate";
    }

    @GetMapping("/condition")
    public String conditionHandler(Model m){
        m.addAttribute("isActive", false);
        m.addAttribute("gender", "M");
        List<Integer> nums = List.of(10,11,12,13,14,15,16);
        m.addAttribute("nums", nums);
        return  "condition";
    }

    @GetMapping("/service")
    public  String serviceHandler(Model m){
        return  "service";
    }
}
