package com.moler.dao;


import com.moler.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();

    void saveBook(Book book);

    Book getBook(int theId);

    void deleteBook(int theId);
}
