package com.marcin.facades.impl;

import com.marcin.domain.Category;
import com.marcin.facades.CategoryFacade;
import com.marcin.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryFacadeImpl implements CategoryFacade {

    private final CategoryService categoryService;

    public CategoryFacadeImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryService.getAllActiveCategories();
    }
}
