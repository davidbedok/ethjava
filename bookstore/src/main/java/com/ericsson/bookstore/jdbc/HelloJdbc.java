package com.ericsson.bookstore.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ericsson.bookstore.domain.BookStub;
import com.ericsson.bookstore.facade.BookJdbcFacade;

public class HelloJdbc {

	private static final Logger LOGGER = Logger.getLogger(HelloJdbc.class);

	private static final String HOST = "localhost";
	private static final int PORT = 5432;
	private static final String DATABASE = "bookstoredb";

	public void execute() throws ClassNotFoundException, SQLException {
		try (final BookJdbcFacade facade = new BookJdbcFacade(HOST, PORT, DATABASE)) {
			final List<BookStub> books = facade.getAllBooks();
			books.stream().forEach(LOGGER::debug);

			final BookStub book = facade.getBook("978-0441172719");
			LOGGER.debug(book);
		}
	}

}
