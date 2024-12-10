package com.backend.ticketbookingsystem.controller;


import com.backend.ticketbookingsystem.configuration.ResponseMessage;
import com.backend.ticketbookingsystem.input.CustomerInputs;
import com.backend.ticketbookingsystem.input.VendorInputs;
import com.backend.ticketbookingsystem.repository.TicketPoolRepository;
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
    @Autowired
    private TicketPoolRepository ticketPoolRepository;


    @PostMapping("/addTicket")
    public ResponseEntity<?> addTicket(@RequestBody VendorInputs vendorInputs){
        ticketPoolService.ticketAdding(vendorInputs.getVendorId(),vendorInputs.getTotalTickets(),vendorInputs.getTicketsPerRelease(),vendorInputs.getVendorRetrievalInterval());
        return ResponseEntity.ok().body(new ResponseMessage("Ticket adding successfully"));
    }
    @PostMapping("/buyTicket")
    public ResponseEntity<?> removeTicket(@RequestBody CustomerInputs customerInputs){
        ticketPoolService.ticketRemoving(customerInputs.getCustomerId(),customerInputs.getBuyTickets());
        if (customerInputs.getBuyTickets() > ticketPoolRepository.findByStatus("available").size()){
            return ResponseEntity.badRequest().body(new ResponseMessage("Tickets not available. please try to buy less than you buy:"));
        }else{
            return ResponseEntity.ok().body(new ResponseMessage("Tickets available"));
        }
    }
}
