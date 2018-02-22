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

	private final Connection connection;

	public BookJdbcFacade(String host, int port, String database) throws SQLException {
		this.connection = DriverManager.getConnection(this.getJdbcUrl(host, port, database), "bookstore_user", "123topSECret321");
	}

	private String getJdbcUrl(String host, int port, String database) {
		return "jdbc:postgresql://" + host + ":" + port + "/" + database;
	}

	@Override
	public void close() {
		try {
			this.connection.close();
		} catch (final SQLException e) {
			LOGGER.error(e, e);
		}
	}

	@Override
	public List<BookStub> getAllBooks() {
		final List<BookStub> result = new ArrayList<>();
		try {
			final Statement statement = this.connection.createStatement();
			final ResultSet rs = statement.executeQuery(GET_ALL_BOOKS);
			while (rs.next()) {
				final String isbn = rs.getString("book_isbn");
				final String author = rs.getString("book_author");
				final String title = rs.getString("book_title");
				final Double price = rs.getDouble("book_price");
				final Integer numberOfPages = rs.getInt("book_number_of_pages");
				final String categoryName = rs.getString("bookcategory_name");

				final BookCategoryStub category = BookCategoryStub.valueOf(categoryName);
				result.add(new BookStub(isbn, author, title, category, price, numberOfPages));
			}
			rs.close();
			statement.close();
		} catch (final SQLException e) {
			LOGGER.error(e, e);
		}
		return result;
	}

	@Override
	public BookStub getBook(String isbn) {
		BookStub result = null;
		try {
			final PreparedStatement statement = this.connection.prepareStatement(GET_BOOK);
			statement.setString(1, isbn);
			final ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				final String author = rs.getString("book_author");
				final String title = rs.getString("book_title");
				final Double price = rs.getDouble("book_price");
				final Integer numberOfPages = rs.getInt("book_number_of_pages");
				final String categoryName = rs.getString("bookcategory_name");

				final BookCategoryStub category = BookCategoryStub.valueOf(categoryName);
				result = new BookStub(isbn, author, title, category, price, numberOfPages);
			}
			rs.close();
			statement.close();
		} catch (final SQLException e) {
			LOGGER.error(e, e);
		}
		return result;
	}

}
