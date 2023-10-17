package com.spring.crud.repo;

import com.spring.crud.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

    List<User> findByName(String name);

    List<User> findByNameAndEmail(String name, String email);
    List<User> findByNameOrEmail(String name, String email);


}
