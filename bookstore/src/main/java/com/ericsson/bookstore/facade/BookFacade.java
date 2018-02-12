package com.ericsson.bookstore.facade;

import java.util.List;

import com.ericsson.bookstore.domain.BookStub;

public interface BookFacade {

	List<BookStub> getAllBooks();

	BookStub getBook(String isbn);

}
