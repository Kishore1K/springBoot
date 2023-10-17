package com.spring.rest_api_1.services;
import java.util.*;
import com.spring.rest_api_1.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    private  static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1,"Java Ref", "James Gosling" ));
        list.add(new Book(2,"Ramayana", "Valmiki" ));
        list.add(new Book(3,"Python", "van Rasom" ));
        list.add(new Book(4,"C Ref", "Dannie Ritche" ));
        list.add(new Book(5,"Harry Potter", "J K Rowling" ));
    }

    public List<Book> getAllBooks(){
        return list;
    }

    public Book getBookById(int id){ 
       Book book = null;
        book = list.stream().filter(e -> e.getId()==id).findFirst().get();
        return book; 
    }

    
}
