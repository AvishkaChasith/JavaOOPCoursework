package com.backend.ticketbookingsystem.service;
import com.backend.ticketbookingsystem.collection.TicketPool;
import com.backend.ticketbookingsystem.input.VendorInputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.ticketbookingsystem.repository.TicketPoolRepository;


@Service
public class TicketPoolService {

    @Autowired
    TicketPoolRepository ticketPoolRepository;

    public void ticketAdding(int vendorId, int totalTickets, int ticketRetrievalRate,int vendorRetrievalInterval){
        VendorInputs vendor1 = new VendorInputs(vendorId,totalTickets,ticketRetrievalRate,vendorRetrievalInterval,this);
        Thread newThread = new Thread(vendor1);
        newThread.start();

    }

    public void saveTicket(TicketPool ticketPool){
        ticketPoolRepository.save(ticketPool);
    }



}
