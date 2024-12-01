package com.backend.ticketbookingsystem.collection;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {
    @Id
    private int customerId = new Object().hashCode();
    private String customerName;
    private String customerLastName;
    private String customerPhone;
    private String customerEmail;
    private String customerPassword;

}
