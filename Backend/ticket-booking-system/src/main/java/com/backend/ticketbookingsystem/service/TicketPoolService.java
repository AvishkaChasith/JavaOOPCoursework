package com.backend.ticketbookingsystem.service;
import com.backend.ticketbookingsystem.collection.TicketPool;
import com.backend.ticketbookingsystem.input.CustomerInputs;
import com.backend.ticketbookingsystem.input.VendorInputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.ticketbookingsystem.repository.TicketPoolRepository;

import javax.management.Query;
import java.util.List;


@Service
public class TicketPoolService {

    @Autowired
    TicketPoolRepository ticketPoolRepository;

    public void ticketAdding(int vendorId, int totalTickets, int ticketRetrievalRate,int vendorRetrievalInterval){
        VendorInputs vendor1 = new VendorInputs(vendorId,totalTickets,ticketRetrievalRate,vendorRetrievalInterval,this);
        Thread vendorThread = new Thread(vendor1);
        vendorThread.start();

    }

    public void saveTicket(TicketPool ticketPool){
        ticketPoolRepository.save(ticketPool);
    }

    public void ticketRemoving(int customerId,int buyTickets){
        CustomerInputs customer1 = new CustomerInputs(customerId,buyTickets,this);
        Thread customerThread = new Thread(customer1);
        customerThread.start();
    }

    public void removeTicket(List<TicketPool> ticketPoolList){
        ticketPoolRepository.deleteAll(ticketPoolList);
    }

    public List<TicketPool> findFirstNByOrderByTicketIdAsc(int n){
        return ticketPoolRepository.findFirstNByOrderByTicketIdAsc(n);
    }


}
