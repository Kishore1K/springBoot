package com.jpa.repo;

import com.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepo extends CrudRepository<User, Long> {
}
