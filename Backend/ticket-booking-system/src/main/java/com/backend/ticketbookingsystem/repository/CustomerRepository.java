package com.backend.ticketbookingsystem.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.backend.ticketbookingsystem.collection.Customer;




@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

}
