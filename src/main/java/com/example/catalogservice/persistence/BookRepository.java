package com.example.catalogservice.persistence;

import java.util.Collection;
import java.util.Optional;

import com.example.catalogservice.domain.Book;

public interface BookRepository {
	
	Collection<Book> findAll();
	Optional<Book> findByIsbn(String isbn);
	boolean existsByIsbn(String isbn);
	Book save(Book book);
	void deleteByIsbn(String isbn);
	Book update(String isbn, Book book);
}
