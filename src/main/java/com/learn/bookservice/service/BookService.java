package com.learn.bookservice.service;


import com.learn.bookservice.api.BookOperations;
import com.learn.bookservice.mapper.BookMapper;
import com.learn.bookservice.model.Book;
import com.learn.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService implements BookOperations {
    private BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper.TO_MODEL)
                .collect(Collectors.toList());

    }

    @Override
    public Book addBook(Book book) {
        com.learn.bookservice.entity.Book eBook = BookMapper.TO_ENTITY.apply(book);
        bookRepository.save(eBook);
        return BookMapper.TO_MODEL.apply(eBook);
    }

    @Override
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(UUID id, Book book) {
        Optional<com.learn.bookservice.entity.Book> eBook = bookRepository.findById(id);
        if (eBook.isPresent()) {
            com.learn.bookservice.entity.Book bookEntity = eBook.get();
            bookEntity = BookMapper.TO_UPDATE.apply(bookEntity, book);
            bookRepository.save(bookEntity);
            return BookMapper.TO_MODEL.apply(bookEntity);
        }
        return null;
    }
}
