package com.springclass.firstproject.service.impl;

import com.springclass.firstproject.dto.CategoryDTO;
import com.springclass.firstproject.entity.Category;
import com.springclass.firstproject.repo.CategoryRepo;
import com.springclass.firstproject.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceIMPL implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCategory(CategoryDTO categoryDTO) {
        Category category=modelMapper.map(categoryDTO,Category.class);
        categoryRepo.save(category);
        return category.getCategoryId()+"saved";
    }
}
