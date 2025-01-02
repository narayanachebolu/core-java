package org.com.java8.features;

import org.com.java8.entity.Book;
import org.com.java8.entity.BookDAO;

import java.util.Collections;
import java.util.List;

public class BookService {

    public List<Book> getBooksSortByName() {
        List<Book> books = new BookDAO().getBooks();
        //books.sort((book1, book2) -> book2.getTitle().compareTo(book1.getTitle()));
        Collections.sort(books, (book1, book2) -> book1.getTitle().compareTo(book2.getTitle()));

        return books;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getBooksSortByName());
    }
}
