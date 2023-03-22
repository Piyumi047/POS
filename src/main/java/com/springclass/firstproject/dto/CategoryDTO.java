package com.springclass.firstproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {

    private int categoryId;
    private String categotyName;
    private int numOfCategories;
    private boolean activeStatus;
}
