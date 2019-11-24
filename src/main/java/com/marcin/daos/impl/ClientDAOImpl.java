package com.marcin.daos.impl;

import com.marcin.daos.ClientDAO;
import com.marcin.domain.Client;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    private EntityManager entityManager;

    public ClientDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Client> getClients() {
        TypedQuery<Client> query = entityManager.createQuery("from Client c", Client.class);
        return query.getResultList();
    }

    @Override
    public void saveClient(Client theClient) {
        entityManager.persist(theClient);
    }

    @Override
    public Client update(Client client) {
        return entityManager.merge(client);
    }

    /**
     * @noinspection UnnecessaryLocalVariable
     */
    @Override
    public Client getClient(int id) {
        Client client = entityManager.find(Client.class, id);
        return client;
    }


}
