package com.springclass.firstproject.repo;

import com.springclass.firstproject.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,String> {
    List<Item> findAllByBlanceQtyEqualsAndActiveStatesEquals(double qty, boolean status);
}
