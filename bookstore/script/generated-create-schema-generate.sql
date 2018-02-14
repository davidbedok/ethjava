create table book (book_id int8 not null, book_author varchar(255) not null, book_bookcategory_id int4 not null, book_isbn varchar(255) not null, book_number_of_pages int4 not null, book_price float8 not null, book_title varchar(255) not null, primary key (book_id))
create sequence book_book_id_seq
