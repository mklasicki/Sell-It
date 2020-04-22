package com.marcin.daos.impl;

import com.marcin.daos.ProductDAO;
import com.marcin.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ProductDAOImpl implements ProductDAO {

    private final EntityManager entityManager;

    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> getProducts() {
        TypedQuery<Product> query = entityManager.createQuery("from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> getProductByName(String productName) {
        List<Product> products = entityManager.createQuery(
                "select p " +
                        "from Product p " +
                        "where p.productName like :productName")
                .setParameter("productName", productName)
                .getResultList();

        if(products.isEmpty()) {
            System.out.println("Nie masz żadnych przedmiotów na liście");
        }
        return products;

    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product getProduct(Long id) {
        return entityManager.find(Product.class, id);
    }

//    @Override
//    public boolean deleteProduct(String productName) {
//        Product product = getProductByName(productName);
//        if (product.getId() != 0) {
//            entityManager.remove(product);
//            System.out.println("Produkt " + product.getProductName() + " został pomyslnie usunięty");
//            return true;
//        } else {
//            System.out.println("Nastapił jakiś błąd");
//            return false;
//        }
//    }
}
