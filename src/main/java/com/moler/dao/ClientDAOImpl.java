package com.moler.dao;

import com.moler.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {



    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Client> getClients() {
        Session session = sessionFactory.getCurrentSession();
        Query<Client> query  = session.createQuery("from Client", Client.class);
        List<Client> clients = query.getResultList();
        return clients;
    }

    @Override
    public void saveClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);
    }

    @Override
    public Client getClientById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class, id);
        return client;
    }

    @Override
    public void deleteClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Client where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public void reserveBook(int bookId, int clientId){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("update Book set client_id=:clientId where id=:bookId");
        query.setParameter("clientId", clientId);
        query.setParameter("bookId", bookId);
        query.executeUpdate();
    }


}
