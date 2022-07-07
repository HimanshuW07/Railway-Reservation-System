package com.example.booking.controller;

import com.example.booking.entities.Book;
import com.example.booking.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableSwagger2
@RequestMapping("/booking")
public class BookController {

    @Autowired
    private BookService bookService;


    //	Author: Himanshu Wakade
    //	Date: 15/04/2022
    //	Modified: 20/04/2022
    //	Desc: Implemented logger method on post request method of Reservation of the User

    Logger logger = LoggerFactory.getLogger(BookController.class);

    //add the user
    @PostMapping("/add-booking")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        logger.info("[postBooking] info booking");
        logger.warn("[postBooking] warn booking");
        logger.error("[postBooking] error booking");
        logger.debug("[postBooking] debug booking");
        logger.trace("[postBooking] trace booking");
        try {
            System.out.println(book);
            bookService.addBook(book);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }





    //	Author: Himanshu Wakade
    //	Date: 15/04/2022
    //	Modified: 20/04/2022
    //	Desc: Implemented logger method on get request method of getting all the booking of that user

    Logger logger1 = LoggerFactory.getLogger(BookController.class);

    //get the user
    @GetMapping("/get-booking")
    public ResponseEntity<List<Book>> getAllBook() {
        logger1.info("[getBooking] info booking");
        logger1.warn("[getBooking] warn booking");
        logger1.error("[getBooking] error booking");
        logger1.debug("[getBooking] debug booking");
        logger1.trace("[getBooking] trace booking");

        List<Book> list = bookService.getAllBooks();

        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }




    //	Author: Himanshu Wakade
    //	Date: 15/04/2022
    //	Modified: 20/04/2022
    //	Desc: Implemented logger method on get request method of getting user by name

    Logger logger2 = LoggerFactory.getLogger(BookController.class);

    //get the user by name
    @GetMapping("/get-user/trainName")
    public ResponseEntity<Book> getBookByTrainName(@RequestParam(value = "trainName") String trainName) {
        logger2.info("[getBooking] info byName");
        logger2.warn("[getBooking] warn byName");
        logger2.error("[getBooking] error byName");
        logger2.debug("[getBooking] debug byName");
        logger2.trace("[getBooking] trace byName");
        try {
            Book book = bookService.getBookByTrainName(trainName);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}