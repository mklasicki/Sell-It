package com.marcin.service.impl;

import com.marcin.repositories.CategoryDAO;
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
    public List<Category> getAllActiveCategories() {
        List<Category> categories = findAll();
        log.info("Getting list of all active categories");
        return categories.stream().filter(Category::isActive).collect(Collectors.toList());
    }

    @Override
    public Category getCategoryById(Long id) {

        Category category = categoryDAO.findById(id);

        if (category == null) {

            log.error("Category with id {} do not exists ", id);

            throw new EntityExistsException("Category with id" + id + "is not in database");
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
