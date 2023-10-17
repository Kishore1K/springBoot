package com.spring.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/home")
    public  void home(){
        System.out.println("MainController.home");
    }


    @RequestMapping("/about")
    @ResponseBody
    public  String about(){
        return "About";
    }

    @RequestMapping("/contact")
    @ResponseBody
    public  String contact(){
        return "ContactPage";
    }


    @RequestMapping("/link")
    @ResponseBody
    public  String link(){
        return "link";
    }

    @RequestMapping("/link1")
    @ResponseBody
    public  String link1(){
        return "link1";
    }

    @RequestMapping("/mail")
    @ResponseBody
    public  String mail(){
        return  "Mail Page";
    }

}
