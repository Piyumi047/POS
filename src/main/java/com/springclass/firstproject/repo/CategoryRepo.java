package com.springclass.firstproject.repo;

import com.springclass.firstproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
