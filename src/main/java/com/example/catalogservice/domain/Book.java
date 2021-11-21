package com.example.catalogservice.domain;

import java.time.Year;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.example.catalogservice.persistence.PersistableEntity;

@Entity
public class Book extends PersistableEntity {
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((publishingYear == null) ? 0 : publishingYear.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (publishingYear == null) {
			if (other.publishingYear != null) {
				return false;
			}
		} else if (!publishingYear.equals(other.publishingYear)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

}
