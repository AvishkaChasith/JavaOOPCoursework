package com.backend.ticketbookingsystem.collection;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vendors")
public class Vendor {

    @Id
    private int vendorId = new ObjectId().hashCode();
    private String vendorName;
    private String vendorLastName;
    private String vendorEmail;
    private String vendorPassword;

}
