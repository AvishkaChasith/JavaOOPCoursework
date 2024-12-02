package com.backend.ticketbookingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.ticketbookingsystem.repository.VendorRepository;
import com.backend.ticketbookingsystem.collection.Vendor;
import java.util.Optional;

@Service
public class VendorService{

    @Autowired
    VendorRepository vendorRepository;

    public void vendorRegister(Vendor vendor){
        vendorRepository.save(vendor);
    }

    public Boolean vendorExists(String vendorEmail){
        return vendorRepository.findByVendorEmail(vendorEmail).isPresent();
    }

    public Boolean confirmVendor(String vendorEmail,String vendorPassword) {
        Optional<Vendor> optionalVendor = vendorRepository.findByVendorEmail(vendorEmail);
        if (optionalVendor.isPresent()){
            if (optionalVendor.get().getVendorPassword().equals(vendorPassword)){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }


}
