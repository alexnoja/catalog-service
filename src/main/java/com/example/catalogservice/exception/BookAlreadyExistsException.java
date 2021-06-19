package com.example.catalogservice.exception;

public class BookAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4516984415067031891L;

	public BookAlreadyExistsException(String isbn) {
		super("A book with ISBN " + isbn + " already exists.");
	}
}
