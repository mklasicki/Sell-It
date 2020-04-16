package com.marcin.daos.impl;

import com.marcin.daos.ProductDAO;
import com.marcin.domain.Product;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManager entityManager;

    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> getProducts() {
        TypedQuery<Product> query = entityManager.createQuery("from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public void saveProduct(Product theProduct) {
        entityManager.persist(theProduct);


    }

    @Override
    public Product getProduct(int id) {
        return null;
    }
}
