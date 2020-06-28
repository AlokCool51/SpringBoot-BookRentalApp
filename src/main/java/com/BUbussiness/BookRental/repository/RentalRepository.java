package com.BUbussiness.BookRental.repository;

import com.BUbussiness.BookRental.model.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental,Integer> {
}
