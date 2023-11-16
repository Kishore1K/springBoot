package com.security;

import com.security.Entity.Role;
import com.security.Entity.Student;
import com.security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {
//        Role studentRole = new Role();
//        studentRole.setRole("STUDENT");
//
//        Student kishore = new Student();
//        kishore.setFName("ankush");
//        kishore.setLName("naik");
//        kishore.setEmail("ankush@gmail.com");
//        kishore.setPassword(passwordEncoder.encode("ankush"));
//        kishore.addRole(studentRole);

//        Student s2 = new Student();
//        s2.setFName("manjunath");
//        s2.setLName("D");
//        s2.setEmail("manju@gmail.com");
//        s2.setPassword(passwordEncoder.encode("manju"));
//        s2.addRole(studentRole);

//        studentRepository.save(kishore);

    }
}
