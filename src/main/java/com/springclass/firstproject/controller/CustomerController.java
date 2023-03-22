package com.springclass.firstproject.controller;

import com.springclass.firstproject.dto.CustomerDTO;
import com.springclass.firstproject.dto.request.CustomerUpdateDTO;
import com.springclass.firstproject.repo.CustomerRepo;
import com.springclass.firstproject.service.CustomerService;
import com.springclass.firstproject.util.StanderdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String SaveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved customer";
    }

    @PutMapping("/update")
    public CustomerDTO updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        return customerService.updateCustomer(customerUpdateDTO);
    }

    @GetMapping(
            path={"/get-by-id"},
            params={"id"}
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerid){
        CustomerDTO c= customerService.getCustomerById(customerid);
        return c;

    }

//    @GetMapping(
//            path = "get-all-customers"
//    )
//    public List<CustomerDTO> getAllCustomers(){
//        List<CustomerDTO> allCustomers=customerService.getallCustomers();
//        return allCustomers;
//    }

    @GetMapping(
            path = "get-all-customers"
    )
    public ResponseEntity<StanderdResponse> getAllCustomers(){
        List<CustomerDTO> allCustomers=customerService.getallCustomers();
        return new ResponseEntity<>(
                new StanderdResponse(200,"Success",allCustomers), HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-by-id/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerid){
        String deleted=customerService.deleteCustomer(customerid);
        return deleted;
    }

    @GetMapping(
            path={"/get-all-customers-by-active-state"},
            params={"status"}
    )
    public List<CustomerDTO> getCustomerByActiveStatus(@RequestParam(value = "status") boolean status){
        List<CustomerDTO> c= customerService.getCustomerByStatus(status);
        return c;

    }
}
