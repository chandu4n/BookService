package com.learn.bookservice.api;

import com.learn.bookservice.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookOperations {

    List<Book> getBooks();

    Book addBook(Book book);

    void deleteBook(UUID id);

    Book updateBook(UUID id, Book book);
}
