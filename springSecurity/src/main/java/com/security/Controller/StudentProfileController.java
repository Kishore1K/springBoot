package com.security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentProfileController {

    @GetMapping("/profile")
    public String getStudentProfile(Model model){
        return "studentProfile";
    }
}
