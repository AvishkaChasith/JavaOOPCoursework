package com.backend.ticketbookingsystem.input;
import com.backend.ticketbookingsystem.collection.TicketPool;
import com.backend.ticketbookingsystem.service.TicketPoolService;
import lombok.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;


@Data
public class VendorInputs implements Runnable {
    private int vendorId;
    private int totalTickets;
    private int ticketsPerRelease;
    private int vendorRetrievalInterval;
    TicketPoolService ticketPoolService;


    public VendorInputs(int vendorId, int totalTickets, int ticketsPerRelease, int vendorRetrievalInterval,TicketPoolService ticketPoolService) {
        this.vendorId = vendorId;
        this.totalTickets = totalTickets;
        this.ticketsPerRelease = ticketsPerRelease;
        this.vendorRetrievalInterval = vendorRetrievalInterval;
        this.ticketPoolService = ticketPoolService;
    }


    public static ReentrantLock lock = new ReentrantLock();
    public static int currentTicketId = 1;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Starting Thread");

        int currentTickets = totalTickets;
        while (currentTickets > 0) {
            try (BufferedWriter vendorWriter = new BufferedWriter(new FileWriter("addTickets.txt", true))) {
                int ticketsToAdd = Math.min(ticketsPerRelease, currentTickets);
                for (int i = 0; i < ticketsToAdd; i++) {
                    TicketPool ticket = new TicketPool();
                    ticket.setVendorId(vendorId);
                    ticket.setTicketId(currentTicketId);
                    ticket.setStatus("available");
                    ticketPoolService.saveTicket(ticket);
                    currentTicketId++;
                    vendorWriter.write("VendorID " + ticket.getVendorId() + " " +
                            " add ticketId : " + ticket.getTicketId() + "\n");
                }
                vendorWriter.newLine();
                currentTickets = currentTickets - ticketsToAdd;
                Thread.sleep(vendorRetrievalInterval);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
