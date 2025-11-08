package com.learn.bookservice.mapper;

import com.learn.bookservice.entity.Book;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BookMapper {

    public static final Function<Book, com.learn.bookservice.model.Book> TO_MODEL = new Function<Book, com.learn.bookservice.model.Book>() {
        @Override
        public com.learn.bookservice.model.Book apply(Book book) {
            return new com.learn.bookservice.model.Book.Builder()
                    .id(book.getId())
                    .isbn(book.getIsbn())
                    .name(book.getName())
                    .author(book.getAuthor())
                    .year(book.getPublishedYear())
                    .price(book.getPrice())
                    .build();
        }
    };

    public static final Function<com.learn.bookservice.model.Book, Book> TO_ENTITY = new Function<com.learn.bookservice.model.Book, Book>() {
        @Override
        public Book apply(com.learn.bookservice.model.Book book) {
            return new Book(book.getId(), book.getIsbn(), book.getName(), book.getAuthor(), book.getYear(), book.getPrice());
        }
    };

    public static final BiFunction<Book, com.learn.bookservice.model.Book,Book> TO_UPDATE=new BiFunction<Book, com.learn.bookservice.model.Book, Book>() {
        @Override
        public Book apply(Book book, com.learn.bookservice.model.Book book2) {
            book.setAuthor(book2.getAuthor());
            book.setIsbn(book2.getIsbn());
            book.setName(book2.getName());
            book.setPrice(book2.getPrice());
            book.setPublishedYear(book2.getYear());
            return book;
        }
    };
}
