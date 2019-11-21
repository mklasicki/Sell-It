package com.marcin.service.impl;

import com.marcin.daos.ClientDAO;
import com.marcin.domain.Client;
import com.marcin.service.CllientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements CllientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    @Transactional
    public List<Client> getClients() {
        return clientDAO.getClients();
    }

    @Override
    @Transactional
    public void saveClient(Client theClient) {
        clientDAO.saveClient(theClient);
    }

    @Override
    @Transactional
    public Client getClient(int id) {
        return clientDAO.getClient(id);
    }
}
