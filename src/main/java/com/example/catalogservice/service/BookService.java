package com.example.catalogservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.catalogservice.domain.Book;
import com.example.catalogservice.exception.BookAlreadyExistsException;
import com.example.catalogservice.exception.BookNotFoundException;
import com.example.catalogservice.persistence.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Iterable<Book> viewBookList() {
		return bookRepository.findAll();
	}
	
	public Optional<Book> viewBookDetails(String isbn) {
		return Optional.of(bookRepository.findByIsbn(isbn)
				.orElseThrow(() -> new BookNotFoundException(isbn)));
	}
	
	public Book addBookToCatalog(Book book) {
		if (bookRepository.existsByIsbn(book.getIsbn())) {
			throw new BookAlreadyExistsException(book.getIsbn());
		}
		return bookRepository.save(book);
	}
	
	public void removeBookFromCatalog(String isbn) {
		if (!bookRepository.existsByIsbn(isbn)) {
			throw new BookNotFoundException(isbn);
		}
		bookRepository.deleteByIsbn(isbn);
	}
}