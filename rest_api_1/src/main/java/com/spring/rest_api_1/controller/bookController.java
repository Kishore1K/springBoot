package com.spring.rest_api_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.spring.rest_api_1.entity.Book;
import com.spring.rest_api_1.services.BookService;

@RestController
public class bookController {

    @Autowired
    private BookService bookService;
    
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks(){

        List<Book> list = this.bookService.getAllBooks();
        return .size()<0 ? ResponseStatus.;

    }


    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id){
        return this.bookService.getBookById(id);

    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return this.bookService.addBook(book);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable("id") int id){
         this.bookService.deleteBook(id);
         return "Book Deleted";
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id){
        return  this.bookService.updateBook(book, id);
    }


}
