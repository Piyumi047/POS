package com.springclass.firstproject.repo;


import com.springclass.firstproject.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {
}
