package com.spring.thymleaf.controller;

import com.spring.thymleaf.entity.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        m.addAttribute("title", "This is Title");
        m.addAttribute("subtitle", LocalDateTime.now().toLocalDate());
        return  "service";
    }

    @GetMapping("/new1")
    public  String inhertanceHandler(){
        return  "about_new";

    }
    @GetMapping("/new2")
    public  String contactHandler(){
        return  "contact";

    }

    @GetMapping("/form")
    public  String formHandler(Model m){
        m.addAttribute("loginData", new LoginData());
        return  "form";
    }

    @PostMapping("/process")
    public  String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result){
        if(result.hasErrors()) {
            System.out.println(result);
            return "form";
        }
        System.out.println(loginData);
        return  "success";

    }
}
