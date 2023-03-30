package com.springclass.firstproject.controller;

import com.springclass.firstproject.dto.CategoryDTO;
import com.springclass.firstproject.service.CategoryService;
import com.springclass.firstproject.util.StanderdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<StanderdResponse> saveCategory(@RequestBody CategoryDTO categoryDTO){
        String a=categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(
                        200,
                        "Successfully Save. Category id is",
                        a
                ), HttpStatus.CREATED
        );
    }

}
