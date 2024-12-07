package com.backend.ticketbookingsystem.controller;
import com.backend.ticketbookingsystem.DTO.VendorLoginRequest;
import com.backend.ticketbookingsystem.input.VendorInputs;
import com.backend.ticketbookingsystem.repository.VendorRepository;
import com.backend.ticketbookingsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.ticketbookingsystem.collection.Vendor;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vendors")
@CrossOrigin(origins = "http://localhost:4200")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @PostMapping(value = "/vendorRegister", produces = "application/json")
    public ResponseEntity<?> createVendor(@RequestBody Vendor vendor){
        Map<String,String> response = new HashMap<>();
        if (vendorService.vendorExists(vendor.getVendorEmail())){
            response.put("message:"," This email is already taken");
            return ResponseEntity.badRequest().body(response);
        }else {
          vendorService.vendorRegister(vendor);
          response.put("message: ","Vendor registered successfully");
          return ResponseEntity.ok().body(response);
        }
    }

    @PostMapping("/vendorLogin")
    public ResponseEntity<?>loginVendor(@RequestBody VendorLoginRequest vendorLoginRequest){
        String vendorEmail = vendorLoginRequest.getVendorEmail();
        String vendorPassword = vendorLoginRequest.getVendorPassword();
        if (vendorService.confirmVendor(vendorEmail, vendorPassword)){
            return ResponseEntity.ok().body("Vendor logging in successfully");
        }else {
            return ResponseEntity.badRequest().body("Vendor credentials are incorrect");
        }
    }
}
