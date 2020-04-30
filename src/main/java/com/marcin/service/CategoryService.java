package com.marcin.service;

import com.marcin.domain.Category;

import java.util.List;

public interface CategoryService {

<<<<<<< HEAD
=======
    List<Category> getAllCategories();

>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
    List<Category> getAllActiveCategories();

    Category getCategoryById(Long id);
}
