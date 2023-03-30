package com.springclass.firstproject.service;

import com.springclass.firstproject.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    String saveCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategories(boolean status);

    String deleteCategory(int category_id);
}
