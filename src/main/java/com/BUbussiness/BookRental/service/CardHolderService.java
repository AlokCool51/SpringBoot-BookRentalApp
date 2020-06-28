package com.BUbussiness.BookRental.service;

import com.BUbussiness.BookRental.model.Book;
import com.BUbussiness.BookRental.model.CardHolder;
import com.BUbussiness.BookRental.repository.CardHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardHolderService {

    @Autowired
    private CardHolderRepository cardHolderRepository;

    public List<CardHolder> getAllCardHolder() {
        List<CardHolder> cardHolders = new ArrayList<CardHolder>();
        cardHolderRepository.findAll().forEach(cardHolder -> cardHolders.add(cardHolder));
        return cardHolders;
    }

    public void addCardHolder(CardHolder cardHolder) {
        cardHolderRepository.save(cardHolderRepository.save(cardHolder));
    }

    public CardHolder getCardHolderById(int id)
    {
        return cardHolderRepository.findById(id).get();
    }
}
