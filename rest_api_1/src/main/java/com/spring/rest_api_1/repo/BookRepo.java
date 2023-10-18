package com.spring.rest_api_1.repo;

import com.spring.rest_api_1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
