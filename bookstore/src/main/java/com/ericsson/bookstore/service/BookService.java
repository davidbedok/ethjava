package com.ericsson.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ericsson.bookstore.entity.Book;

public class BookService {

	private final EntityManagerFactory factory;
	private final EntityManager entityManager;

	public BookService(String persistenceUnitName) {
		this.factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.entityManager = this.factory.createEntityManager();
	}

	public List<Book> getAllBooks() {
		final TypedQuery<Book> query = this.entityManager.createQuery("SELECT b FROM Book b", Book.class);
		return query.getResultList();
	}

	public Book getBook(String isbn) {
		final TypedQuery<Book> query = this.entityManager.createNamedQuery(Book.GET_BY_ISBN, Book.class).setParameter("isbn", isbn);
		return query.getSingleResult();
	}

	public void close() throws Exception {
		this.entityManager.close();
		this.factory.close();
	}

}
