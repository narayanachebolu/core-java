package org.com.java8.entity;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getBooks() {
        List<Book> books = new ArrayList();

        books.add(new Book(101, "Core Java 8", "Jashuva", 8.0, "Euro"));
        books.add(new Book(101, "Core Java 11", "Yanik", 11.0, "Euro"));
        books.add(new Book(101, "Core Java 17", "Stenner", 17.0, "Euro"));
        books.add(new Book(101, "Hibernate", "Klaus", 20.0, "Euro"));
        books.add(new Book(101, "Spring Boot 3", "Otto", 25.0, "Euro"));

        return books;
    }
}