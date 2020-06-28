package com.BUbussiness.BookRental.service;

import com.BUbussiness.BookRental.model.Book;
import com.BUbussiness.BookRental.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook(){
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

}
