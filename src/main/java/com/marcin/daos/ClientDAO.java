package com.marcin.daos;

import com.marcin.domain.Client;

import java.util.List;

public interface ClientDAO {

    List<Client> getClients();

    void saveClient(Client theClient);

    Client getClient(int id);

    Client update(Client client);
}
