package com.spring.rest_api_1.services;
import java.util.*;
import java.util.stream.Collectors;

import com.spring.rest_api_1.entity.Book;
import com.spring.rest_api_1.repo.BookRepo;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    private BookRepo bookRepo;
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

 /*   private  static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1,"Java Ref", "James Gosling" ));
        list.add(new Book(2,"Ramayana", "Valmiki" ));
        list.add(new Book(3,"Python", "van Rasom" ));
        list.add(new Book(4,"C Ref", "Dannie Ritche" ));
        list.add(new Book(5,"Harry Potter", "J K Rowling" ));
    }*/

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(int id) {

        return bookRepo.findById(id);

    }


    public Book addBook(Book book){
        return  bookRepo.save(book);
    }


    public void deleteBook(int id){
//        list= list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
        bookRepo.deleteById(id);
    }


    public Book updateBook(Book book, int id) {
/*        list = list.stream().map(book1 -> {
            if(book1.getId()==id){
                book1.setTitle(book.getTitle());
                book1.setAuthor(book.getAuthor());

            }
            return book1;
        }).collect(Collectors.toList());
        return  getBookById(id);*/
        book.setId(id);
        return  bookRepo.save(book);
    }


}
