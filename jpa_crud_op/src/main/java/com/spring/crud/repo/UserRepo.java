package com.spring.crud.repo;

import com.spring.crud.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

    List<User> findByName(String name);

    List<User> findByNameAndEmail(String name, String email);
    List<User> findByNameOrEmail(String name, String email);

//    Custome Query

    @Query( "select  u FROM  User u")
    List<User> findAllUser();

    @Query("SELECT  u from User  u WHERE  u.name =:n or u.location=:c")
    public List<User> getUserbyNameACity(@Param("n") String name, @Param("c") String city);


    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getAll();


}
