package com.learn.bookservice.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.UUID;

@JsonDeserialize(builder = Book.Builder.class)
public class Book {
    private UUID id;
    private String isbn;
    private String name;
    private String author;
    private Integer year;
    private Integer price;

    public UUID getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPrice() {
        return price;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private Book book;

        public Builder() {
            this.book = new Book();
        }

        public Builder id(UUID id) {
            this.book.id = id;
            return this;
        }

        public Builder isbn(String isbn) {
            this.book.isbn = isbn;
            return this;
        }

        public Builder name(String name) {
            this.book.name = name;
            return this;
        }

        public Builder author(String author) {
            this.book.author = author;
            return this;
        }

        public Builder year(Integer year) {
            this.book.year = year;
            return this;
        }

        public Builder price(Integer price) {
            this.book.price = price;
            return this;
        }

        public Book build() {
            return this.book;
        }
    }
}
