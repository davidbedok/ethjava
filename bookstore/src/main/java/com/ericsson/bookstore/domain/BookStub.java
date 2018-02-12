package com.ericsson.bookstore.domain;

public class BookStub {

	private String isbn;
	private String author;
	private String title;
	private BookCategoryStub category;
	private double price;
	private int numberOfPages;

	public BookStub(String isbn, String author, String title, BookCategoryStub category, double price, int numberOfPages) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.category = category;
		this.price = price;
		this.numberOfPages = numberOfPages;
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

	public BookCategoryStub getCategory() {
		return this.category;
	}

	public void setCategory(BookCategoryStub category) {
		this.category = category;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumberOfPages() {
		return this.numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "BookStub [isbn=" + this.isbn + ", author=" + this.author + ", title=" + this.title + ", category=" + this.category + ", price=" + this.price
				+ ", numberOfPages=" + this.numberOfPages + "]";
	}

}
