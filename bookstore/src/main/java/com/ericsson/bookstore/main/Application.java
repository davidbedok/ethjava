package com.ericsson.bookstore.main;

import com.ericsson.bookstore.jdbc.HelloJdbc;
import com.ericsson.bookstore.jpa.HelloJpa;

public class Application {

	private static final String PERSISTENCE_UNIT = "bs-persistence-unit";
	private static final String PERSISTENCE_UNIT_GENERATE = "bs-persistence-unit-generate";
	private static final String PERSISTENCE_UNIT_SCRIPT = "bs-persistence-unit-script";

	public static void main(String[] args) throws Exception {
		new HelloJdbc().execute();
		new HelloJpa().execute(PERSISTENCE_UNIT);
	}

}
