package com.backend.ticketbookingsystem.controller;
import com.backend.ticketbookingsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.ticketbookingsystem.collection.Vendor;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @PostMapping("/vendorRegister")
    public ResponseEntity<?> createVendor(@RequestBody Vendor vendor){
        if (vendorService.vendorExists(vendor.getVendorEmail())){
            return ResponseEntity.badRequest().body("This email is already taken");
        }else {
          vendorService.vendorRegister(vendor);
          return ResponseEntity.ok().body("Vendor registered successfully");
        }
    }

    @PostMapping("/vendorLogin")
    public ResponseEntity<?>loginVendor(@RequestBody String vendorEmail){
        if (vendorService.confirmVendor(vendorEmail)){
            return ResponseEntity.ok().body("Vendor logging in successfully");
        }else {
            return ResponseEntity.badRequest().body("Vendor credentials are incorrect");
        }
    }


}
