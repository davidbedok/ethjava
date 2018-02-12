package com.ericsson.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ericsson.bookstore.entity.Book;

public class BookService {


	public BookService(String persistenceUnitName) {
	}

	public List<Book> getAllBooks() {
		return null;
	}

	public Book getBook(String isbn) {
		return null;
	}

	public void close() throws Exception {
	}

}
