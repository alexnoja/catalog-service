package com.example.catalogservice.domain;

import java.time.Year;

public class Book {
	
	private String isbn;
	private String title;
	private String author;
	private Year publishingYear;
	private Double price;

	public Book(String isbn, String title, String author, Year publishingYear, Double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishingYear = publishingYear;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Year getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(Year publishingYear) {
		this.publishingYear = publishingYear;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
