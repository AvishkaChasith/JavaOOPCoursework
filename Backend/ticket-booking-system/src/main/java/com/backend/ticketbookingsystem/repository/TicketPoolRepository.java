package com.backend.ticketbookingsystem.repository;

import com.backend.ticketbookingsystem.collection.TicketPool;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketPoolRepository extends MongoRepository<TicketPool, Integer> {
    List<TicketPool> findByStatus(String status);




}
