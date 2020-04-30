package com.marcin.daos.impl;

import com.marcin.daos.ProductDAO;
import com.marcin.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
=======


>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ProductDAOImpl implements ProductDAO {

    private final EntityManager entityManager;
<<<<<<< HEAD

=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed

    public ProductDAOImpl(EntityManager entityManager) { this.entityManager = entityManager;
    }

    @Override
    public List<Product> getProducts() {
        TypedQuery<Product> query = entityManager.createQuery("from Product p", Product.class);
        return query.getResultList();
    }

    @Override
<<<<<<< HEAD
    public List<Product> getProductByName(String productName) {
        List<Product> products = entityManager.createQuery(
=======
    public Product getProductByName(String productName) {
        Product product = (Product) entityManager.createQuery(
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
                "select p " +
                        "from Product p " +
                        "where p.productName like :productName")
                .setParameter("productName", productName)
<<<<<<< HEAD
                .getResultList();

        if(products.isEmpty()) {
            System.out.println("Nie masz żadnych przedmiotów na liście");
        }
        return products;
    }

    @Override
    @Transactional
    public List<Product> getProductByUserId(Long userId) {
        List<Product> userProducts = entityManager.createQuery(
                    "select p from Product p where user_id like: user_id")
                .setParameter("user_id", userId)
                .getResultList();
        return userProducts;
=======
                .getSingleResult();
        return product;
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product getProduct(Long id) {
<<<<<<< HEAD
        return entityManager.find(Product.class, id);
    }

    @Override
    public void deleteProduct(Long id) {
       Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);

=======
        Product product = entityManager.find(Product.class, id);
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
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
    }

}
