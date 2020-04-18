package com.marcin.service.impl;

import com.marcin.daos.CategoryDAO;
import com.marcin.domain.Category;
import com.marcin.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> getAllCategories() {
        return findAll();
    }

    @Override
    public List<Category> getAllActiveCategories() {
        List<Category> categories = findAll();
        return categories.stream().filter(Category::isActive).collect(Collectors.toList());
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryDAO.findById(id);
        if (category == null) {
            log.error("Kategoria z {} nie istnieje w bazie", id);
            throw new EntityExistsException("Kategoria z " + id + "nie istnieje w bazie");
        }
        return category;
    }

    private List<Category> findAll() {
        List<Category> categories = categoryDAO.findAll();
        if (categories == null || categories.isEmpty())
            return Collections.emptyList();
        return categories;
    }
}
