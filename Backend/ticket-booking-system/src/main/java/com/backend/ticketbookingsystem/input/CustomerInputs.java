package com.backend.ticketbookingsystem.input;
import com.backend.ticketbookingsystem.collection.TicketPool;
import com.backend.ticketbookingsystem.service.TicketPoolService;
import lombok.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        List<TicketPool> ticketPoolList = ticketPoolService.getAvailableTickets();

        synchronized (ticketPoolService){
            if (ticketPoolList.size()>= buyTickets){

                try(BufferedWriter customerWriter = new BufferedWriter(new FileWriter("buyTickets.txt",true))){

                    for (int i = 0; i < buyTickets; i++) {
                        TicketPool ticketPool = ticketPoolList.get(i);
                        customerWriter.write("Customer ID: "+customerId+" buy tickets:");
                        customerWriter.write(String.valueOf(ticketPool.getTicketId()));
                        customerWriter.newLine();
                        ticketPool.setStatus("Sold");
                        ticketPoolService.updateTicket(ticketPool);
                    }
                    customerWriter.newLine();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("Ticket buy successfully for customer "+ customerId);

            }else{
                System.out.println("Ticket not enough for customer "+ customerId);
            }
        }
    }

}
