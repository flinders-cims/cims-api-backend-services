package com.flinders.cims.controller;

import com.flinders.cims.model.ChemicalInHand;
import com.flinders.cims.model.ServiceRequest;
import com.flinders.cims.model.ServiceRequestDTO;
import com.flinders.cims.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cims/service-requests")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    // Create a new ServiceRequest
    @PostMapping("/create")
    public ResponseEntity<ServiceRequest> createServiceRequest(@RequestBody ServiceRequestDTO serviceRequest) {
        ServiceRequest createdRequest = serviceRequestService.saveServiceRequest(serviceRequest);
        return ResponseEntity.ok(createdRequest);
    }

    // Get all ServiceRequests
    @GetMapping("/get-all")
    public ResponseEntity<List<ServiceRequest>> getAllServiceRequests() {
        List<ServiceRequest> serviceRequests = serviceRequestService.getAllServiceRequests();
        return ResponseEntity.ok(serviceRequests);
    }

    @GetMapping("/get-all/{userId}/status/{status}")
    public ResponseEntity<List<ServiceRequest>> getServiceRequestsByUserAndStatus(
            @PathVariable int userId,
            @PathVariable String status) {

        List<ServiceRequest> serviceRequests = serviceRequestService.getServiceRequestsByUserAndStatus(userId, status);

        if (serviceRequests.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(serviceRequests);
    }

    // Get a single ServiceRequest by ID
    @GetMapping("/get/{userId}")
    public ResponseEntity<ServiceRequest> getServiceRequestById(@PathVariable int userId) {
        Optional<ServiceRequest> serviceRequest = serviceRequestService.getServiceRequestById(userId);
        return serviceRequest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing ServiceRequest
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceRequest> updateServiceRequest(@PathVariable int userId, @RequestBody ServiceRequestDTO serviceRequestDTO) {
        Optional<ServiceRequest> existingServiceRequest = serviceRequestService.getServiceRequestById(userId);
        if (existingServiceRequest.isPresent()) {
            ServiceRequest updatedRequest = serviceRequestService.updateServiceRequest(existingServiceRequest.get(), serviceRequestDTO);
            return ResponseEntity.ok(updatedRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRequest(@PathVariable int id) {
        serviceRequestService.deleteServiceRequest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/in-hand/{userId}")
    public ResponseEntity<List<ChemicalInHand>> getChemicalsInHandByUserAndStatus(
            @PathVariable int userId) {
        List<ChemicalInHand> chemicalsInHand = serviceRequestService.getChemicalsInHand(userId,"approved");
        return ResponseEntity.ok(chemicalsInHand);
    }

}

