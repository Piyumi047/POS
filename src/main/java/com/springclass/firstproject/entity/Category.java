package com.springclass.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {

    @Id
    @Column(name = "category_id",length = 45)
    private int categoryId;

    @Column(name = "category_name",nullable = false)
    private String categoryName;

    @Column(name = "num_of_items")
    private int numOfItems;

    @Column(name = "active_states",columnDefinition = "TINYINT DEFAULT 0")
    private boolean activeStatus;
}
