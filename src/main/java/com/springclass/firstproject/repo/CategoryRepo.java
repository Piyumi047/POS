package com.springclass.firstproject.repo;

import com.springclass.firstproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    List<Category> findAllByActiveStatusEquals(boolean status);
}
