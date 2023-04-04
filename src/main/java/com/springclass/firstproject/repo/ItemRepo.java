package com.springclass.firstproject.repo;

import com.springclass.firstproject.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByBlanceQtyEqualsAndActiveStatesEquals(double qty, boolean status);

    Page<Item> findAllByActiveStatesEquals(boolean status, Pageable pageable);

    long countAllByActiveStatesEquals(boolean status);
}
