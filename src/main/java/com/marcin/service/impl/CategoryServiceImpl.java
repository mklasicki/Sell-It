package com.marcin.service.impl;

import com.marcin.exceptions.CategoryNotFountException;
import com.marcin.repositories.CategoryRepository;
import com.marcin.domain.Category;
import com.marcin.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllActiveCategories() {
        List<Category> categories = categoryRepository.findAll();
        log.info("[CategoryServiceImpl]: Getting list of all active categories");
        return categories.stream().filter(Category::isActive).collect(Collectors.toList());
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new CategoryNotFountException("Category with id " + id + " not found"));
    }

}
