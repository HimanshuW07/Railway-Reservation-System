package com.example.booking.dao;

import com.example.booking.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book, Integer> {

    public Book findByTrainName(String trainName);
}
