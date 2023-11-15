package com.security;

import com.security.Entity.Role;
import com.security.Entity.Student;
import com.security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {
        Role studentRole = new Role();
        studentRole.setRole("STUDENT");

        Student kishore = new Student();
        kishore.setFName("Kishore");
        kishore.setLName("reddy");
        kishore.setEmail("kishore@gmail.com");
        kishore.setPassword(passwordEncoder.encode("12345678"));
        kishore.addRole(studentRole);
        studentRepository.save(kishore);
    }
}
