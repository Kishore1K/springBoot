package com.example.jpa_view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("MainController.home");
        return  "home";
    }
}
