package com.moler.service;

import com.moler.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    void saveBook(Book book);

    Book getBook(int theId);

    void deleteBook(int theId);
}
