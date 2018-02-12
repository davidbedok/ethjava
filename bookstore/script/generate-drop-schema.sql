DROP TABLE book;
DROP SEQUENCE book_book_id_seq;
DROP TABLE bookcategory;

CREATE TABLE bookcategory ( bookcategory_id INTEGER NOT NULL, bookcategory_name CHARACTER VARYING(100) NOT NULL, CONSTRAINT PK_BOOKCATEGORY_ID PRIMARY KEY (bookcategory_id) );