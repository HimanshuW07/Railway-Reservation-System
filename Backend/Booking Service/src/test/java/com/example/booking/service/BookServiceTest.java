package com.example.booking.service;

import com.example.booking.dao.BookRepo;
import com.example.booking.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepo bookRepo;

    @Test
    public void getBookTest()
    {
        List<Book> list = new ArrayList<Book>();
        Book trainOne = new Book("123","ABC Express","Sunday","32","Delhi","Nagpur","5","AC-chair");
        Book trainTwo = new Book("5","Express","Sunay","31","Dehi","Nagur","60","AC-hair");
        Book trainThree = new Book("52","ABC ","Suday","56","elhi","Nagpr","84","AC-chr");

        list.add(trainOne);
        list.add(trainTwo);
        list.add(trainThree);

        when(bookRepo.findAll()).thenReturn(list);

        List<Book> bookList = bookService.getAllBooks();

        assertEquals(3,bookList.size());
        verify(bookRepo,times(1)).findAll();
    }

}