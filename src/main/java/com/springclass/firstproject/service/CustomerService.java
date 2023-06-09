package com.springclass.firstproject.service;

import com.springclass.firstproject.dto.CustomerDTO;
import com.springclass.firstproject.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getallCustomers();

    public String saveCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerid);

    String deleteCustomer(int customerid);

    List<CustomerDTO> getCustomerByStatus(boolean status);


    List<CustomerDTO> getCustomerByNIC(String customer_nic);

    List<CustomerDTO> getallCustomerByName(String customer_name);


    CustomerDTO updateCustomerStatus(int customerId, boolean customerStatus);
}
