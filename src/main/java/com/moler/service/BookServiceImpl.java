package com.moler.service;

import com.moler.dao.BookDAO;
import com.moler.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public Book getBook(int theId) {
        return bookDAO.getBook(theId);
    }

    @Override
    @Transactional
    public void deleteBook(int theId) {
        bookDAO.deleteBook(theId);
    }
}
