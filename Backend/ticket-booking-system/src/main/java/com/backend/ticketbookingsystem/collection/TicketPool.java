package com.backend.ticketbookingsystem.collection;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "tickets")
public class TicketPool {
    @Id
    private int ticketId;
    private int vendorId;
    private String vendorName;

}
