package com.jpa;

import com.jpa.entity.User;
import com.jpa.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaViewApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaViewApplication.class, args);
        UserRepo userRepo = context.getBean(UserRepo.class);
        User user = new User( 1, "Kishore", "kishore@gmail.com", "kgf", "single");
        System.out.println("userRepo.save(user) = " + userRepo.save(user));
    }

}
