package com.marcin.service.impl;

import com.marcin.daos.CategoryDAO;
import com.marcin.domain.Category;
import com.marcin.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

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

    private List<Category> findAll() {
        List<Category> categories = categoryDAO.findAll();
        if (categories == null || categories.isEmpty())
            return Collections.emptyList();
        return categories;
    }
}
