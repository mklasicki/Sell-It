package com.marcin.daos.impl;

import com.marcin.daos.ProductDAO;
import com.marcin.domain.Product;
import org.springframework.security.core.parameters.P;
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
    public Product getProductByName(String productName) {
        Product product = (Product) entityManager.createQuery(
                "select p " +
                        "from Product p " +
                        "where p.productName like :productName")
                .setParameter("productName", productName)
                .getSingleResult();
        return product;
    }

    @Override
    public void saveProduct(Product theProduct) {
        entityManager.persist(theProduct);
    }

    @Override
    public Product getProduct(Long id) {
        Product product = new Product();
        product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public boolean deleteProduct(String productName) {
        Product product = getProductByName(productName);
        if (product.getId() != 0) {
            entityManager.remove(product);
            System.out.println("Produkt " + product.getProductName() + " został pomyslnie usunięty");
            return true;
        } else {
            System.out.println("Nastapił jakiś błąd");
            return false;
        }
    }
}
