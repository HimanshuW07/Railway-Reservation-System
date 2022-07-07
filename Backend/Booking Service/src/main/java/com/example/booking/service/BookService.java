package com.example.booking.service;

import com.example.booking.dao.BookRepo;
import com.example.booking.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public void addBook(Book book) {
        System.out.println(book);
        bookRepo.save(book);
        System.out.println("Booking Done Successfully");
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookByTrainName(String trainName) {
        return bookRepo.findByTrainName(trainName);
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }
}
