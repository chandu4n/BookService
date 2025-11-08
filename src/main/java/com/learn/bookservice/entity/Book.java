package com.learn.bookservice.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "PUBLISHED_YEAR")
    private Integer publishedYear;
    @Column(name = "PRICE")
    private Integer price;

    public Book() {

    }

    public Book(UUID id, String isbn, String name, String author, Integer publishedYear, Integer price) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
