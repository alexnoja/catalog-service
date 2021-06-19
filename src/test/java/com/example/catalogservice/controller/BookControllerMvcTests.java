package com.example.catalogservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.catalogservice.exception.BookNotFoundException;
import com.example.catalogservice.service.BookService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

@WebMvcTest(BookController.class)
public class BookControllerMvcTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;
	
	@Test
	void whenReadingNotExistingBookThenShouldReturn404() throws Exception {
		String isbn = "11223344556";
		given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);
		mockMvc.perform(get("/books" + isbn))
			   .andExpect(status().isNotFound());
	}
}
