package com.springclass.firstproject.controller;

import com.springclass.firstproject.dto.CategoryDTO;
import com.springclass.firstproject.service.CategoryService;
import com.springclass.firstproject.util.StanderdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(
            path = "/get-all-category-by-status",
            params = "status"
    )
    public ResponseEntity<StanderdResponse> getallCategory(@RequestParam(value = "status")boolean status){
         List<CategoryDTO> categoryDTOS=categoryService.getAllCategories(status);
         return new ResponseEntity<StanderdResponse>(
                 new StanderdResponse(200,"All Categories comes",categoryDTOS),HttpStatus.OK
         );
    }

    @DeleteMapping(
            path = "/delete-category/{id}"
    )
    public ResponseEntity<StanderdResponse> deleteCategory(@PathVariable(value = "id")int category_id){
        String message=categoryService.deleteCategory(category_id);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Deleted",message),
                HttpStatus.OK
        );
    }




}
