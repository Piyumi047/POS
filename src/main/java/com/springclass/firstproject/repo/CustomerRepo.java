package com.springclass.firstproject.repo;

import com.springclass.firstproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByActiveStatesEquals(boolean status);

    List<Customer> findAllByNicEquals(String customer_nic);

//    Customer getReferenceById(String customerid);
//
//    boolean existsById(String customerid);
}
