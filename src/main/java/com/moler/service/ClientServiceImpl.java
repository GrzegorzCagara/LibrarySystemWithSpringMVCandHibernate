package com.moler.service;

import com.moler.dao.ClientDAO;
import com.moler.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDAO clientDAO;

    @Override
    @Transactional
    public List<Client> getClients() {
        return clientDAO.getClients();
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    @Transactional
    public Client getClientById(int id) {
        return clientDAO.getClientById(id);
    }

    @Override
    @Transactional
    public void deleteClient(int id) {
        clientDAO.deleteClient(id);
    }

    @Override
    @Transactional
    public void reserveBook(int bookId, int clientId) {
        clientDAO.reserveBook(bookId, clientId);
    }


}
