package com.backend.ticketbookingsystem.DTO;


import lombok.Data;

@Data
public class VendorLoginRequest {
    private String vendorEmail;
    private String vendorPassword;
}
