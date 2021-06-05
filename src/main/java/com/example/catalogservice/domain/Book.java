package com.example.catalogservice.domain;

import java.time.Year;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
	
	private String isbn;
	private String title;
	private String author;
	private Year publishingYear;
	private Double price;
}
