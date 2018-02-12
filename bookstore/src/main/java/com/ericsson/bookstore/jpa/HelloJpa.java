package com.ericsson.bookstore.jpa;

import java.util.List;

import org.apache.log4j.Logger;

import com.ericsson.bookstore.domain.BookStub;
import com.ericsson.bookstore.facade.BookJpaFacade;

public class HelloJpa {

	private static final Logger LOGGER = Logger.getLogger(HelloJpa.class);

	public void execute(String persistenceUnitName) throws Exception {
		try (final BookJpaFacade facade = new BookJpaFacade(persistenceUnitName)) {
			final List<BookStub> books = facade.getAllBooks();
			books.stream().forEach(LOGGER::debug);

			final BookStub book = facade.getBook("978-0441172719");
			LOGGER.debug(book);
		}
	}

}
