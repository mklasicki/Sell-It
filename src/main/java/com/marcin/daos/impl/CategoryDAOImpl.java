package com.marcin.daos.impl;

import com.marcin.daos.CategoryDAO;
import com.marcin.domain.Category;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CategoryDAOImpl implements CategoryDAO {

    private final EntityManager entityManager;

    public CategoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Category> findAll() {
        return entityManager
                .createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    @Override
    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }
}
