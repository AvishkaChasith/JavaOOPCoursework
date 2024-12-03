package com.backend.ticketbookingsystem.input;
import com.backend.ticketbookingsystem.collection.TicketPool;
import com.backend.ticketbookingsystem.service.TicketPoolService;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class CustomerInputs implements Runnable{

    private int customerId;
    private int buyTickets;
    CustomerInputs customerInputs;

    TicketPoolService ticketPoolService;

    public CustomerInputs(int customerId, int buyTickets){
        this.customerId = customerId;
        this.buyTickets = buyTickets;
    }

    @Override
    public void run(){
        ticketPoolService.removeTicket(buyTickets);
    }

}
