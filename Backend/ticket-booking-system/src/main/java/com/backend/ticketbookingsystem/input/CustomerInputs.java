package com.backend.ticketbookingsystem.input;
import com.backend.ticketbookingsystem.collection.TicketPool;
import com.backend.ticketbookingsystem.service.TicketPoolService;
import lombok.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;


@Data
public class CustomerInputs implements Runnable{

    private int customerId;
    private int buyTickets;
    TicketPoolService ticketPoolService;


    public CustomerInputs(int customerId, int buyTickets, TicketPoolService ticketPoolService) {
        this.customerId = customerId;
        this.buyTickets = buyTickets;
        this.ticketPoolService=ticketPoolService;
    }

    @Override
    public void run(){
        List<TicketPool> ticketPoolList = ticketPoolService.findFirstNByOrderByTicketIdAsc(buyTickets);

        synchronized (ticketPoolService){
            if (ticketPoolList.size()>= buyTickets){
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("buyTickets.txt",true))){
                    writer.write("Customer ID: "+customerId+"buy tickets:");
                    for (TicketPool ticketPool : ticketPoolList){
                        writer.write(ticketPool.getTicketId());
                    }
                    writer.newLine();
                }catch (Exception e){
                    e.printStackTrace();
                }

                ticketPoolService.removeTicket(ticketPoolList);
                System.out.println("Ticket buy successfully for customer "+ customerId);

            }else{
                System.out.println("Ticket not enough for customer "+ customerId);
            }
        }
    }

}
