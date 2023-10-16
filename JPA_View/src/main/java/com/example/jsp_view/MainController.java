package com.example.jsp_view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("MainController.home");
        return  "home";
    }

    @RequestMapping("/contact")
    public  String contact(){
        System.out.println("MainController.contact");
        return  "contact";
    }
}
