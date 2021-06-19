package com.example.catalogservice.controller;

import java.time.Year;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.catalogservice.domain.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookControllerIntegrationTests {

	private static final String URL = "http://localhost:9001/books";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	void whenPostRequestThenBookCreated() {
		Book expectedBook = new Book("1234567890", "Title", "Author", Year.of(2021), 9.90);
		ResponseEntity<Book> response = restTemplate.postForEntity(URL, expectedBook, Book.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getIsbn()).isEqualTo(expectedBook.getIsbn());
	}
}
