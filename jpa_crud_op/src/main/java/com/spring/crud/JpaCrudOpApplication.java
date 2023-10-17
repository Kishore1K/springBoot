package com.spring.crud;

import com.spring.crud.entity.User;
import com.spring.crud.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaCrudOpApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaCrudOpApplication.class, args);
        UserRepo userRepo = context.getBean(UserRepo.class);
/*

        User user = new User();
        user.setName("Kishore");
        user.setLocation("Kgf");
        user.setEmail("kishore@gmail.com");

        userRepo.save(user);
*/

        //create object of user
/*
        User user1 = new User();
        user1.setEmail("kishore1@gmail.com");
        user1.setName("kishore1");
        user1.setLocation("mys");

        User user2 = new User();
        user2.setEmail("ankush@gmail.com");
        user2.setName("ankush");
        user2.setLocation("bangalore");

        Iterable<User>   result  = userRepo.saveAll(List.of(user1, user2));

        result.forEach(user -> {
            System.out.println(user);

        } );*/

        //update

/*        Optional<User> optional = userRepo.findById(11);

        User user = optional.get();

        user.setName("manju");
        user.setEmail("manju@gmail.com");

        userRepo.save(user);*/
        
        
        
        Iterable<User> itr = userRepo.findAll();
        itr.forEach(user -> {
            System.out.println("user = " + user);
        });

        userRepo.deleteById(11);

        System.out.println("After delete");

        Iterable<User> itr1 = userRepo.findAll();
        itr1.forEach(user -> {
            System.out.println("user = " + user);
        });


    }

}
