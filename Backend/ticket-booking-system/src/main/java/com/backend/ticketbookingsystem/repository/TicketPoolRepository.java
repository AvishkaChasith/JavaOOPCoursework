package com.backend.ticketbookingsystem.repository;

import com.backend.ticketbookingsystem.collection.TicketPool;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketPoolRepository extends MongoRepository<TicketPool, Integer> {
    default List<TicketPool> findFirstNByOrderByTicketIdAsc(int n){
        PageRequest pageRequest = PageRequest.of(0, n, Sort.by(Sort.Direction.ASC,"ticketId"));
        return findAll(pageRequest).getContent();
    }

}
