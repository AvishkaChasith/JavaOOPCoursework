package com.backend.ticketbookingsystem.repository;

import com.backend.ticketbookingsystem.collection.TicketPool;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPoolRepository extends MongoRepository<TicketPool, Integer> {

}
