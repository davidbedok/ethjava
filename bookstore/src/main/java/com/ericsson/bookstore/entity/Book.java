package com.ericsson.bookstore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ericsson.bookstore.entity.trunk.BookCategory;

@Entity
@Table(name = "book")
@SequenceGenerator(name = "generatorBook", sequenceName = "book_book_id_seq", allocationSize = 1)
@NamedQuery(name = Book.GET_BY_ISBN, query = "SELECT b FROM Book b WHERE b.isbn=:isbn")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String GET_BY_ISBN = "Book.getByIsbn";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorBook")
	@Column(name = "book_id", nullable = false)
	private Long id;

	@Column(name = "book_isbn", nullable = false)
	private String isbn;

	@Column(name = "book_author", nullable = false)
	private String author;

	@Column(name = "book_title", nullable = false)
	private String title;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "book_bookcategory_id", nullable = false)
	private BookCategory category;

	@Column(name = "book_price", nullable = false)
	private Double price;

	@Column(name = "book_number_of_pages", nullable = false)
	private Integer numberOfPages;

	public Book() {
		this(null, null, null, 0, 0, BookCategory.SCIFI);
	}

	public Book(String isbn, String author, String title, int numberOfPages, double price, BookCategory category) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookCategory getCategory() {
		return this.category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumberOfPages() {
		return this.numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "Book [id=" + this.id + ", isbn=" + this.isbn + ", author=" + this.author + ", title=" + this.title + ", category=" + this.category + ", price="
				+ this.price + ", numberOfPages=" + this.numberOfPages + "]";
	}

}
