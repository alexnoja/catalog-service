package com.example.catalogservice.demo;

import java.time.Year;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.catalogservice.domain.Book;
import com.example.catalogservice.persistence.BookRepository;

@Component
@Profile("test-data")// Assign the class to the "test-data" profile: it will be registered only when the "test-data" profile is active
public class BookDataLoader {

	private final BookRepository bookRepository;

	public BookDataLoader(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@EventListener(ApplicationReadyEvent.class)// The test data generation is triggered when an ApplicationReadyEvent is sent, that is when the application startup phase is completed 
	public void loadBookTestData() {
		Book book1 = new Book("9780132350884", "Clean Code", "Robert Martin", Year.of(2008), 33.33);
		Book book2 = new Book("0134494164", "Clean Architecture", "Robert Martin", Year.of(2017), 32.00);
		bookRepository.save(book1);
		bookRepository.save(book2);
	}
	
}
