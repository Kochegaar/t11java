package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public Book() {

    }

    public String getAuthor() {
        return author;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }


    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }
}