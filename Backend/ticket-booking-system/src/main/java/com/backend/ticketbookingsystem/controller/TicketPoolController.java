package com.backend.ticketbookingsystem.controller;


import com.backend.ticketbookingsystem.input.CustomerInputs;
import com.backend.ticketbookingsystem.input.VendorInputs;
import com.backend.ticketbookingsystem.service.TicketPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendors/vendorLogin")
public class TicketPoolController {

    @Autowired
    TicketPoolService ticketPoolService;


    @PostMapping("/addTicket")
    public ResponseEntity<?> addTicket(@RequestBody VendorInputs vendorInputs){
        ticketPoolService.ticketAdding(vendorInputs.getVendorId(),vendorInputs.getTotalTickets(),vendorInputs.getTicketsPerRelease(),vendorInputs.getVendorRetrievalInterval());
        return ResponseEntity.ok().body("Ticket adding successfuly");
    }
    @PostMapping("/buyTicket")
    public ResponseEntity<?> removeTicket(@RequestBody CustomerInputs customerInputs){
        ticketPoolService.ticketRemoving(customerInputs.getCustomerId(),customerInputs.getBuyTickets());
        return ResponseEntity.ok().body("Ticket Buying successfully");
    }
}
