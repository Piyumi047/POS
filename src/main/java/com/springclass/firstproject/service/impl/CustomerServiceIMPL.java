package com.springclass.firstproject.service.impl;

import com.springclass.firstproject.dto.CustomerDTO;
import com.springclass.firstproject.dto.request.CustomerUpdateDTO;
import com.springclass.firstproject.dto.response.ItemGetResponseDTO;
import com.springclass.firstproject.entity.Customer;
import com.springclass.firstproject.exception.NotFoundException;
import com.springclass.firstproject.repo.CustomerRepo;
import com.springclass.firstproject.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CustomerDTO> getallCustomers() {
        List<Customer> getAllCustomers=customerRepo.findAll();
        if(getAllCustomers.size()>0){
            List<CustomerDTO> customerDTOList = new ArrayList<>();
            for (Customer c : getAllCustomers) {

                //use normal way to map the data
//                CustomerDTO customerDTO = new CustomerDTO(
//                        c.getCustomerId(),
//                        c.getCustomerName(),
//                        c.getCustomerAddress(),
//                        c.getContactNumbers(),
//                        c.getNic(),
//                        c.isActiveStates()
//                );

                //use modelMppper for map the data
                CustomerDTO customerDTO=modelMapper.map(c,CustomerDTO.class);
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        }
        else{
            throw new RuntimeException("No customer in database");
        }

    }

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        //use normal way to map the data
//        Customer customer=new Customer(
//                customerDTO.getCustomerId(),
//                customerDTO.getCustomerName(),
//                customerDTO.getCustomerAddress(),
//                customerDTO.getContactNumbers(),
//                customerDTO.getNic(),
//                customerDTO.isActiveStates()
//        );
        //use Model Mapper
        Customer customer=modelMapper.map(customerDTO,Customer.class);
        customerRepo.save(customer);

        return customerDTO.getCustomerName()+"saved";
    }

    @Override
    public CustomerDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
             Customer customer=customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
             customer.setCustomerName(customerUpdateDTO.getCustomerName());
             customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
             customer.setNic(customerUpdateDTO.getNic());

             customerRepo.save(customer);
            //use normal way to map the data

//             CustomerDTO customerDTO=new CustomerDTO(
//                   customer.getCustomerId(),
//                   customer.getCustomerName(),
//                   customer.getCustomerAddress(),
//                   customer.getContactNumbers(),
//                   customer.getNic(),
//                     customer.isActiveStates()
//             );

            //use Model Mapper
            CustomerDTO customerDTO=modelMapper.map(customer,CustomerDTO.class);

             return customerDTO;

        }
        else{
            throw new RuntimeException("No data found for that relevent Id customer");
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerid) {
        if(customerRepo.existsById(customerid)){
            Customer customer=customerRepo.getReferenceById(customerid);
            //use normal way to map the data

//            CustomerDTO customerDTO=new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getContactNumbers(),
//                    customer.getNic(),
//                    customer.isActiveStates()
//            );

            //use Model Mapper
            CustomerDTO customerDTO=modelMapper.map(customer,CustomerDTO.class);
            return customerDTO;

        }else {
          //  throw new RuntimeException("No data found for that relevent Id customer");
            throw new NotFoundException("Not Fount Customer for that Id");
        }
    }

    @Override
    public String deleteCustomer(int customerid) {
        if(customerRepo.existsById(customerid)){
            customerRepo.deleteById(customerid);
            return "Delete Successfully"+customerid;
        }else {
           throw new RuntimeException("No data found for that relevent Id customer");

        }
    }

    @Override
    public List<CustomerDTO> getCustomerByStatus(boolean status) {
        List<Customer> getAllCustomers=customerRepo.findAllByActiveStatesEquals(status);
        if(getAllCustomers.size()>0){
            List<CustomerDTO> customerDTOList = new ArrayList<>();
            for (Customer c : getAllCustomers) {
                //use normal way to map the data
//                CustomerDTO customerDTO = new CustomerDTO(
//                        c.getCustomerId(),
//                        c.getCustomerName(),
//                        c.getCustomerAddress(),
//                        c.getContactNumbers(),
//                        c.getNic(),
//                        c.isActiveStates()
//                );

                //use Model Mapper
                CustomerDTO customerDTO=modelMapper.map(c,CustomerDTO.class);
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        }
        else{
            throw new RuntimeException("No customer in database");
        }

    }

    @Override
    public List<CustomerDTO> getCustomerByNIC(String customer_nic) {
        List<Customer> allCustomersByNIC=customerRepo.findAllByNicEquals(customer_nic);
        if(allCustomersByNIC.size()>0){
            List<CustomerDTO> customerDTOList=new ArrayList<>();
            for(Customer c:allCustomersByNIC){
                //use normal way to map the data
//                CustomerDTO customerDTO=new CustomerDTO(
//                        c.getCustomerId(),
//                        c.getCustomerName(),
//                        c.getCustomerAddress(),
//                        c.getContactNumbers(),
//                        c.getNic(),
//                        c.isActiveStates()
//                );

                //use Model Mapper
                CustomerDTO customerDTO=modelMapper.map(c,CustomerDTO.class);
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        }
        else {
            throw new RuntimeException("No Customers for provided NIC");
        }
    }

    @Override
    public List<CustomerDTO> getallCustomerByName(String customer_name) {
        List<Customer> allCustomersByName=customerRepo.findAllByCustomerNameEquals(customer_name);
        if (allCustomersByName.size()>0){
            List<CustomerDTO> customerDTOList=new ArrayList<>();
            for (Customer customer:allCustomersByName){
                //use normal way to map the data
//                CustomerDTO customerDTO=new CustomerDTO(
//                        customer.getCustomerId(),
//                        customer.getCustomerName(),
//                        customer.getCustomerAddress(),
//                        customer.getContactNumbers(),
//                        customer.getNic(),
//                        customer.isActiveStates()
//                );

                //use Model Mapper
                CustomerDTO customerDTO=modelMapper.map(customer,CustomerDTO.class);
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        }
        else {
            throw new RuntimeException("NO Customers for provided Name");
        }
    }

    @Override
    public CustomerDTO updateCustomerStatus(int customerId, boolean customerStatus) {
        if(customerRepo.existsById(customerId)){
            Customer customer=customerRepo.getReferenceById(customerId);
            customer.setActiveStates(customerStatus);

            //use normal way to map the data
//            CustomerDTO customerDTO=new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getContactNumbers(),
//                    customer.getNic(),
//                    customer.isActiveStates()
//
//            );

            //use Model Mapper
            CustomerDTO customerDTO=modelMapper.map(customer,CustomerDTO.class);
           return customerDTO;

        }
        else {
            throw new RuntimeException("NO CUSTOMER FOR PROVIDED ID");
        }
    }


}
