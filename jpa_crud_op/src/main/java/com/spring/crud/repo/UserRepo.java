package com.spring.crud.repo;

import com.spring.crud.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
