package com.BUbussiness.BookRental.model;

import javax.persistence.*;

@Entity
@Table
public class Rental {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private CardHolder cardHolder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Book book;

    private Rental(){
    }

    public Rental(CardHolder cardHolder, Book book) {

        this.cardHolder = cardHolder;
        this.book = book;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
