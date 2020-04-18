package com.marcin.daos;

import com.marcin.domain.Category;

import java.util.List;

/**
 * Interfejs DAO, który zarządza obiektami Category
 */

public interface CategoryDAO {

    List<Category> findAll();

    Category findById(Long id);
}
