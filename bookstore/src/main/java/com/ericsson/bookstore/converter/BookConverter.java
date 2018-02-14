package com.ericsson.bookstore.converter;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.bookstore.domain.BookCategoryStub;
import com.ericsson.bookstore.domain.BookStub;
import com.ericsson.bookstore.entity.Book;

public class BookConverter {

	public BookStub to(Book book) {
		final BookCategoryStub category = BookCategoryStub.valueOf(book.getCategory().name());
		return new BookStub(book.getIsbn(), book.getAuthor(), book.getTitle(), category, book.getPrice(), book.getNumberOfPages());
	}

	public List<BookStub> to(List<Book> books) {
		final List<BookStub> result = new ArrayList<>();
		books.stream().map(this::to).forEach(result::add);
		return result;
	}

}
