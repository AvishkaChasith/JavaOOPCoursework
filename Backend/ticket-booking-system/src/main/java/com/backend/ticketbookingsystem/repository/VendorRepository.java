package com.backend.ticketbookingsystem.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.backend.ticketbookingsystem.collection.Vendor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, Integer> {
    Optional<?> findByVendorEmail(String vendorEmail);
    Optional<?> findByVendorPassword(String vendorPassword);

}
