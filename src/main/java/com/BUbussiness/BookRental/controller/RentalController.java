package com.BUbussiness.BookRental.controller;

import com.BUbussiness.BookRental.Exception.DataNotFoundException;
import com.BUbussiness.BookRental.model.Book;
import com.BUbussiness.BookRental.model.CardHolder;
import com.BUbussiness.BookRental.service.BookService;
import com.BUbussiness.BookRental.service.CardHolderService;
import com.BUbussiness.BookRental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {

    @Autowired
    BookService bookService;

    @Autowired
    CardHolderService cardHolderService;

    @Autowired
    RentalService rentalService;

    @GetMapping("/cardHolder")
    private List<CardHolder> getAllCardHolder() {
        return cardHolderService.getAllCardHolder();
    }

    @PostMapping("/cardHolder")
    private void saveCardHolder(@RequestBody CardHolder cardHolder){
        cardHolderService.addCardHolder(cardHolder);
    }

    @GetMapping("/book")
    private List<Book> getAllBook()
    {
        return bookService.getAllBook();
    }

    @PostMapping("/book")
    private void saveBook(@RequestBody Book book){
         bookService.addBook(book);
    }

    @PostMapping("/rentBook")
    private String saveRentalBook(@RequestParam(name = "bookId") int bookId,
                                @RequestParam(name = "holderId") int holderId) throws DataNotFoundException {
        return rentalService.addRentalBook(bookId,holderId);
    }

    @GetMapping("/allRentedBook")
    private List<Book> getAllRentedBook() throws DataNotFoundException {
        return rentalService.getAllRentedBooks();
    }
}
