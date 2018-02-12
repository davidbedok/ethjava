package com.ericsson.bookstore.facade;

import java.util.List;

import com.ericsson.bookstore.converter.BookConverter;
import com.ericsson.bookstore.domain.BookStub;
import com.ericsson.bookstore.service.BookService;

public class BookJpaFacade implements AutoCloseable, BookFacade {

	private final BookService service;
	private final BookConverter converter;

	public BookJpaFacade(String persistenceUnitName) {
		this.service = new BookService(persistenceUnitName);
		this.converter = new BookConverter();
	}

	@Override
	public List<BookStub> getAllBooks() {
		return this.converter.to(this.service.getAllBooks());
	}

	@Override
	public BookStub getBook(String isbn) {
		return this.converter.to(this.service.getBook(isbn));
	}

	@Override
	public void close() throws Exception {
		this.service.close();
	}

}
