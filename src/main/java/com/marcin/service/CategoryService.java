package com.marcin.service;

import com.marcin.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Category> getAllActiveCategories();
}
