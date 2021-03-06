package com.example.catalogservice.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.catalogservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	Optional<Book> findByIsbn(String isbn);
	boolean existsByIsbn(String isbn);
	@Transactional
	void deleteByIsbn(String isbn);
}
