package com.backend.ticketbookingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.ticketbookingsystem.repository.VendorRepository;
import com.backend.ticketbookingsystem.collection.Vendor;

import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public Vendor vendorRegister(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    public Boolean vendorExists(String vendorEmail){
        return vendorRepository.findByVendorEmail(vendorEmail)!=null;
    }


    public Boolean confirmVendor(String vendorEmail,String vendorPassword) {
        Optional<?> vendor = vendorRepository.findByVendorEmail(vendorEmail);
        if (vendor) {
            return true;
        }else {
            return false;
        }
    }



}
