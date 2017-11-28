package com.moler.dao;

import com.moler.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Book> getBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("from Book", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }

    @Override
    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    @Override
    public Book getBook(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, theId);
        return book;
    }

    @Override
    public void deleteBook(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("delete from Book where id=:bookId");
        query.setParameter("bookId", theId);
        query.executeUpdate();
    }

    public List<Book> reservedBookList(int clientId){
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("from Book where client_id=:clientId");
        query.setParameter("clientId", clientId);
        List<Book> books = query.getResultList();
        return books;
    }
}
