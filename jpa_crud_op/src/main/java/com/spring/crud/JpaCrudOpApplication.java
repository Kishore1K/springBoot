package com.spring.crud;

import com.spring.crud.entity.User;
import com.spring.crud.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaCrudOpApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaCrudOpApplication.class, args);
        UserRepo userRepo = context.getBean(UserRepo.class);

        User user = new User();
        user.setName("Kishore");
        user.setLocation("Kgf");
        user.setEmail("kishore@gmail.com");

        userRepo.save(user);

    }

}
