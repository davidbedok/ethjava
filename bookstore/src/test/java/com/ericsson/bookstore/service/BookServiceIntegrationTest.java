package com.ericsson.bookstore.service;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ericsson.bookstore.entity.Book;
import com.ericsson.bookstore.entity.trunk.BookCategory;

public class BookServiceIntegrationTest {

	private static final String PERSISTENCE_UNIT = "bs-persistence-unit";

	private BookService service;

	@BeforeClass
	public void setup() {
		this.service = new BookService(PERSISTENCE_UNIT);
	}

	@Test
	public void getAllBooksFromDatabase() {
		final List<Book> books = this.service.getAllBooks();
		Assert.assertEquals(books.size(), 3);
	}

	@Test
	public void getBookFromDatabase() {
		final Book book = this.service.getBook("978-0441172719");
		Assert.assertEquals(book.getAuthor(), "Frank Herbert");
		Assert.assertEquals(book.getTitle(), "Dune");
		Assert.assertEquals(book.getCategory(), BookCategory.SCIFI);
		Assert.assertEquals(book.getPrice(), 3500d);
		Assert.assertEquals(book.getNumberOfPages(), Integer.valueOf(896));
	}

}
