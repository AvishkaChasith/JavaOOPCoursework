package com.backend.ticketbookingsystem.DTO;


import lombok.Data;

@Data
public class CustomerLoginRequest {

    private String customerEmail;
    private String customerPassword;

}
