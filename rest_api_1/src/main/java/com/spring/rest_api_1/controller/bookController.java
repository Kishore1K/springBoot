package com.spring.rest_api_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest_api_1.entity.Book;
import com.spring.rest_api_1.services.BookService;

@RestController
public class bookController {

    @Autowired
    private BookService bookService;
    
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks(){

        
        return this.bookService.getAllBooks();

    }


    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id){
        return this.bookService.getBookById(id);

    }
}
