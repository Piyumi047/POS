package com.springclass.firstproject.controller;

import com.springclass.firstproject.dto.CustomerDTO;
import com.springclass.firstproject.dto.request.CustomerUpdateDTO;
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
    public ResponseEntity<StanderdResponse> SaveCustomer(@RequestBody CustomerDTO customerDTO){
        String message=customerService.saveCustomer(customerDTO);

        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successfully Saved",message),HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<StanderdResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
       // return customerService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successfully updated",customerService.updateCustomer(customerUpdateDTO)),
                HttpStatus.OK
        );
    }

    @PutMapping(
            path = "/update-customer-status",
            params = {"status","id"}
    )
    private ResponseEntity<StanderdResponse> deactivateCustomer(
            @RequestParam(value = "status") boolean customerStatus,
            @RequestParam(value = "id")int customerId
    ){
        CustomerDTO customerDTO=customerService.updateCustomerStatus(customerId,customerStatus);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successful",customerDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path={"/get-by-id"},
            params={"id"}
    )
    public ResponseEntity<StanderdResponse> getCustomerById(@RequestParam(value = "id") int customerid){
        CustomerDTO c= customerService.getCustomerById(customerid);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successful",c),
                HttpStatus.OK
        );

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
    public ResponseEntity<StanderdResponse> deleteCustomer(@PathVariable(value = "id") int customerid){
        String deleted=customerService.deleteCustomer(customerid);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successfully Deleted",deleted),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path={"/get-all-customers-by-active-state"},
            params={"status"}
    )
    public ResponseEntity<StanderdResponse> getCustomerByActiveStatus(@RequestParam(value = "status") boolean status){
        List<CustomerDTO> c= customerService.getCustomerByStatus(status);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successful",c),
                HttpStatus.OK
        );

    }

    @GetMapping(
            path = "/get-customers-by-nic",
            params = "nic"
    )
    public ResponseEntity<StanderdResponse> getallCustomersByNIC(@RequestParam(value = "nic") String customer_nic){
        List<CustomerDTO> customerListByNIC=customerService.getCustomerByNIC(customer_nic);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successfull",customerListByNIC),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-customers-by-name/{name}"
    )
    public ResponseEntity<StanderdResponse> getallCustomersByName(@PathVariable(value = "name") String customer_name){
        List<CustomerDTO> allCustomersByName=customerService.getallCustomerByName(customer_name);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successful",allCustomersByName),
                HttpStatus.OK
        );
    }
}
