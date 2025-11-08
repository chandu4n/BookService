package com.learn.bookservice.controller;


import com.learn.bookservice.api.BookOperations;
import com.learn.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookOperations bookOperations;

    @Autowired
    public BookController(BookOperations bookOperations) {
        this.bookOperations = bookOperations;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks() {
        return bookOperations.getBooks();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book addBook(@RequestBody Book book) {
        return bookOperations.addBook(book);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book updateBook(@PathVariable UUID id, @RequestBody Book book) {
        return bookOperations.updateBook(id,book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable UUID id) {
        bookOperations.deleteBook(id);
    }

}
