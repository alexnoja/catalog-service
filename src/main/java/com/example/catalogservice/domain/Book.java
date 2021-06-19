package com.example.catalogservice.domain;

import java.time.Year;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class Book {
	
	@NotBlank(message = "The book ISBN must be defined.")
	@Pattern(regexp = "^(97([89]))?\\d{9}(\\d|X)$", message = "The ISBN format must follow the standards ISBN-10 or ISBN-13.")
	private String isbn;
	
	@NotBlank(message = "The book title must be defined.")
	private String title;
	
	@NotBlank(message = "The book author must be defined.")
	private String author;
	
	@PastOrPresent(message = "The book cannot have been published in the future.")
	private Year publishingYear;
	
	@NotNull(message = "The book price must be defined.")
	@Positive(message = "The book price must be greater than zero.")
	private Double price;
	
	public Book() {
	}

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
