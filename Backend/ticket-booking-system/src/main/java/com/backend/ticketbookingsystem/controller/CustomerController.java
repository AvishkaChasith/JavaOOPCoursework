package com.backend.ticketbookingsystem.controller;

import com.backend.ticketbookingsystem.DTO.CustomerLoginRequest;
import com.backend.ticketbookingsystem.collection.Customer;
import com.backend.ticketbookingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customerRegister")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        if (customerService.customerExists(customer.getCustomerEmail())){
            return ResponseEntity.badRequest().body("This email is already taken");
        }else{
            customerService.customerRegister(customer);
            return ResponseEntity.ok().body("customer registered successfully");
        }
    }

    @PostMapping("customerLogin")
    public ResponseEntity<?> loginCustomer(@RequestBody CustomerLoginRequest customerLoginRequest){
        String customerEmail = customerLoginRequest.getCustomerEmail();
        String customerPassword = customerLoginRequest.getCustomerPassword();
        if (customerService.confirmCustomer(customerEmail,customerPassword)){
            return ResponseEntity.ok().body("customer logged in successfully");
        }else {
            return ResponseEntity.badRequest().body("customer credentials are incorrect");
        }
    }

}
