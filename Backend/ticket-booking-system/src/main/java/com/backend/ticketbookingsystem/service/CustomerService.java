package com.backend.ticketbookingsystem.service;
import com.backend.ticketbookingsystem.collection.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.ticketbookingsystem.repository.CustomerRepository;

import java.util.Optional;


@Service
public class CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public void customerRegister(Customer customer){
        customerRepository.save(customer);
    }

    public Boolean customerExists(String customerEmail) {
        return customerRepository.findByCustomerEmail(customerEmail).isPresent();
    }

    public Boolean confirmCustomer(String customerEmail,String customerPassword){
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerEmail(customerEmail);
        if (optionalCustomer.isPresent()){
            if (customerPassword.equals(optionalCustomer.get().getCustomerPassword())){
                return true;
            }else{
                return false;
            }

        }else {
            return false;
        }
    }

}
