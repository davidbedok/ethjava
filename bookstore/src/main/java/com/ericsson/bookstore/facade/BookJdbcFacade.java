package com.ericsson.bookstore.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ericsson.bookstore.domain.BookCategoryStub;
import com.ericsson.bookstore.domain.BookStub;
import com.ericsson.bookstore.jdbc.HelloJdbc;

public class BookJdbcFacade implements AutoCloseable, BookFacade {

	private static final Logger LOGGER = Logger.getLogger(HelloJdbc.class);

	private static final String GET_ALL_BOOKS = "SELECT " //
			+ " book_isbn," //
			+ " book_author," //
			+ " book_title," //
			+ " book_price," //
			+ " book_number_of_pages," //
			+ " bookcategory_name " //
			+ "FROM book " //
			+ " INNER JOIN bookcategory ON " //
			+ "  ( book_bookcategory_id = bookcategory_id ) " //
			+ "ORDER BY " //
			+ " book_title ";

	private static final String GET_BOOK = "SELECT " //
			+ " book_isbn," //
			+ " book_author," //
			+ " book_title," //
			+ " book_price," //
			+ " book_number_of_pages," //
			+ " bookcategory_name " //
			+ "FROM book " //
			+ " INNER JOIN bookcategory ON " //
			+ "  ( book_bookcategory_id = bookcategory_id ) " //
			+ "WHERE ( 1 = 1 ) " //
			+ " AND ( book_isbn = ? ) " //
			+ "ORDER BY " //
			+ " book_title ";

	public BookJdbcFacade(String host, int port, String database) throws SQLException {
	}

	private String getJdbcUrl(String host, int port, String database) {
		return "jdbc:postgresql://" + host + ":" + port + "/" + database;
	}

	@Override
	public void close() {
	}

	@Override
	public List<BookStub> getAllBooks() {
		final List<BookStub> result = new ArrayList<>();
		return result;
	}

	@Override
	public BookStub getBook(String isbn) {
		BookStub result = null;
		return result;
	}

}
