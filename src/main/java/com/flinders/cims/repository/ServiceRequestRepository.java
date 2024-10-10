package com.flinders.cims.repository;

import com.flinders.cims.model.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {
    // You can add custom query methods here if needed
}
