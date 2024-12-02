package com.backend.ticketbookingsystem.input;
import com.backend.ticketbookingsystem.collection.TicketPool;
import com.backend.ticketbookingsystem.service.TicketPoolService;
import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;


@Data
public class VendorInputs implements Runnable{
    private int vendorId;
    private int totalTickets;
    private int ticketsPerRelease;
    private int vendorRetrievalInterval;
    TicketPoolService ticketPoolService;

    public VendorInputs(int vendorId, int totalTickets, int ticketsPerRelease, int vendorRetrievalInterval, TicketPoolService ticketPoolService){
        this.vendorId = vendorId;
        this.totalTickets = totalTickets;
        this.ticketsPerRelease = ticketsPerRelease;
        this.vendorRetrievalInterval = vendorRetrievalInterval;
        this.ticketPoolService = ticketPoolService;
    }

    public static ReentrantLock lock = new ReentrantLock();
    public static int currentTicketId=1;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": Starting Thread");

        int currentTickets = totalTickets;
        while(currentTickets>0){
            try{
                int ticketsToAdd = Math.min(ticketsPerRelease,currentTickets);
                for (int i = 0;i<ticketsToAdd;i++){
                    TicketPool ticket = new TicketPool();
                    ticket.setVendorId(vendorId);
                    ticket.setTicketId(currentTicketId);
                    ticketPoolService.saveTicket(ticket);
                    currentTicketId++;
                }
                currentTickets= currentTickets-ticketsToAdd;
                Thread.sleep(vendorRetrievalInterval);

            }catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
