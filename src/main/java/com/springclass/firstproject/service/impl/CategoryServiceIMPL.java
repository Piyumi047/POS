package com.springclass.firstproject.service.impl;

import com.springclass.firstproject.dto.CategoryDTO;
import com.springclass.firstproject.dto.response.ItemGetResponseDTO;
import com.springclass.firstproject.entity.Category;
import com.springclass.firstproject.repo.CategoryRepo;
import com.springclass.firstproject.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<CategoryDTO> getAllCategories(boolean status) {
        List<Category> allCategories=categoryRepo.findAllByActiveStatusEquals(status);
        if(allCategories.size()>0){
            List<CategoryDTO> categoryDTOS=modelMapper.map(allCategories,new TypeToken<List<CategoryDTO>>(){}.getType());
            return categoryDTOS;
        }else{
            throw new RuntimeException("No categeries for given status");
        }

    }
}
