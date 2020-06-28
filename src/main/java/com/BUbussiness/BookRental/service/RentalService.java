package com.BUbussiness.BookRental.service;

import com.BUbussiness.BookRental.Exception.DataNotFoundException;
import com.BUbussiness.BookRental.model.Book;
import com.BUbussiness.BookRental.model.CardHolder;
import com.BUbussiness.BookRental.model.Rental;
import com.BUbussiness.BookRental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CardHolderService cardHolderService;

    @Autowired
    private BookService bookService;



    public String addRentalBook(int bookId, int holderId) throws DataNotFoundException {

        try{
            Book book = bookService.getBookById(bookId);
            CardHolder cardHolder = cardHolderService.getCardHolderById(holderId);
            List<Integer> bookIds = new ArrayList<Integer>();
            rentalRepository.findAll().forEach(rental -> bookIds.add(rental.getBook().getId()));
            if(bookIds.contains(bookId)){
                return "This book is already rented";
            }
            else {
                rentalRepository.save(new Rental(cardHolder,book));
                return "The book with id " + bookId + "is issued by " + holderId;
            }
        }
        catch (Exception exp){
            throw new DataNotFoundException("Either the book or the user doesn't exist");
        }


    }

    public List<Book> getAllRentedBooks() throws DataNotFoundException {
        try {
            List<Book> books = new ArrayList<Book>();
            rentalRepository.findAll().forEach(rental -> books.add((Book) rental.getBook()));
            return books;
        }
        catch (Exception exp) {
           throw  new DataNotFoundException("No book exists");
        }
    }

}
