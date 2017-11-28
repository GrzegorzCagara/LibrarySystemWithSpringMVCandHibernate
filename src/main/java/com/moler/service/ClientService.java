package com.moler.service;

import com.moler.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClients();
    void saveClient(Client client);
    Client getClientById(int id);
    void deleteClient(int id);
    void reserveBook(int bookId, int clientId);
}
