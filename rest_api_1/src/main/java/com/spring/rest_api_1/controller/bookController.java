package com.spring.rest_api_1.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.spring.rest_api_1.entity.Book;
import com.spring.rest_api_1.services.BookService;

@RestController
public class bookController {

    public bookController(BookService bookService) {
        this.bookService = bookService;
    }

    private BookService bookService;
    
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<?> getBooks(){

        List<Book> list = this.bookService.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }


    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") int id){
        Book book =  this.bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(book);

    }

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        return ResponseEntity.ok(this.bookService.addBook(book));
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
