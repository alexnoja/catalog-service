package com.example.catalogservice.exception;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -562202895035060711L;

	public BookNotFoundException(String isbn) {
		super("The book with ISBN " + isbn + " was not found.");
	}
}
