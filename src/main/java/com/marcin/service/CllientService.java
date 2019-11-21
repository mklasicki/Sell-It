package com.marcin.service;

import com.marcin.domain.Client;
import java.util.List;


public interface CllientService  {
     List<Client> getClients();

    void saveClient(Client theClient);

    Client getClient(int id);
}
