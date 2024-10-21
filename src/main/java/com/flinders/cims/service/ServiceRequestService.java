package com.flinders.cims.service;

import com.flinders.cims.model.*;
import com.flinders.cims.repository.ServiceRequestRepository;
import com.flinders.cims.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceRequestService {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;
    @Autowired
    private RandomNumber randomNumber;
    @Autowired
    private ChemicalService chemicalService;
    @Autowired
    private ResearchService researchService;
    @Autowired
    private UserService userService;

    // Create or Update a ServiceRequest
    public ServiceRequest saveServiceRequest(ServiceRequestDTO serviceRequestDTO) {
        // Generate a random 4-digit userId
        int srId = randomNumber.generateRandomNumber();
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setSrId(srId);

        Chemical chemical = chemicalService.getChemicalByName(serviceRequestDTO.getChemicalName()).orElse(null);
        Research research = researchService.getResearchByTitle(serviceRequestDTO.getResearchTitle());
        User user = userService.getUserById(serviceRequestDTO.getUserId());

        RiskLevel riskLevel = evaluateRisk(serviceRequestDTO.getRiskScore());
        serviceRequest.setUser(user);
        serviceRequest.setResearch(research);
        serviceRequest.setChemical(chemical);
        serviceRequest.setStatus(serviceRequestDTO.getStatus());
        serviceRequest.setRiskLevel(riskLevel);
        serviceRequest.setDateRequested(serviceRequestDTO.getDateRequested());
        serviceRequest.setApproverUsername(serviceRequestDTO.getApproverUsername());
        serviceRequest.setQuantityRequested(serviceRequestDTO.getQuantityRequested());
        serviceRequest.setUnitOfQuantity(serviceRequestDTO.getUnitOfQuantity());
        serviceRequest.setRiskScore(serviceRequestDTO.getRiskScore());
        serviceRequest.setCasNumber(serviceRequestDTO.getCasNumber());
        serviceRequest.setHazardType(serviceRequestDTO.getHazardType());
        serviceRequest.setToxic(serviceRequestDTO.isToxic());
        serviceRequest.setToxicEffect(serviceRequestDTO.getToxicEffect());

        return serviceRequestRepository.save(serviceRequest);
    }

    // Retrieve a list of all ServiceRequests
    public List<ServiceRequest> getAllServiceRequests() {
        return serviceRequestRepository.findAll();
    }

    // Retrieve a single ServiceRequest by ID
    public Optional<ServiceRequest> getServiceRequestById(int id) {
        return serviceRequestRepository.findById(id);
    }

    // Delete a ServiceRequest by ID
    public void deleteServiceRequest(int id) {
        serviceRequestRepository.deleteById(id);
    }

    public ServiceRequest updateServiceRequest(ServiceRequest existingServiceRequest, ServiceRequestDTO serviceRequest) {

        // Check and update the status field
        if (serviceRequest.getStatus() != null) {
            existingServiceRequest.setStatus(serviceRequest.getStatus());
        }

        // Check and update approverComments field
        if (serviceRequest.getApproverComments() != null) {
            existingServiceRequest.setApproverComment(serviceRequest.getApproverComments());
        }

        // Check and update dateApproved field
        if (serviceRequest.getDateApproved() != null) {
            existingServiceRequest.setDateApproved(serviceRequest.getDateApproved());
        }

        // Check and update dateRejected field
        if (serviceRequest.getDateRejected() != null) {
            existingServiceRequest.setDateRejected(serviceRequest.getDateRejected());
        }

        // Check and update dateClosed field
        if (serviceRequest.getDateClosed() != null) {
            existingServiceRequest.setDateClosed(serviceRequest.getDateClosed());
        }

        // Check and update approverUsername field
        if (serviceRequest.getApproverUsername() != null) {
            existingServiceRequest.setApproverUsername(serviceRequest.getApproverUsername());
        }

        // Check and update quantityDisposed field (ensure it's greater than 0)
        if (serviceRequest.getQuantityDisposed() > 0) {
            existingServiceRequest.setQuantityDisposed(serviceRequest.getQuantityDisposed());
        }

        // Check and update quantityReturned field (ensure it's greater than 0)
        if (serviceRequest.getQuantityReturned() > 0) {
            existingServiceRequest.setQuantityReturned(serviceRequest.getQuantityReturned());
        }

        // Check and update returnedDate field
        if (serviceRequest.getReturnedDate() != null) {
            existingServiceRequest.setReturnedDate(serviceRequest.getReturnedDate());
        }

//        // Check and update storageLocationId field (ensure it's greater than 0)
//        if (serviceRequest.getStorageLocationId() > 0) {
//            StorageLocation storageLocation = storageLocationRepository.findById(serviceRequest.getStorageLocationId())
//                    .orElseThrow(() -> new RuntimeException("Storage location not found"));
//            existingServiceRequest.setStorageLocation(storageLocation);
//        }

        // Check and update isStored field
        if (serviceRequest.isStored()) {
            existingServiceRequest.setStored(serviceRequest.isStored());
        }

        // Check and update isDisposed field
        if (serviceRequest.isDisposed()) {
            existingServiceRequest.setDisposed(serviceRequest.isDisposed());
        }

        // Save the updated entity
        return serviceRequestRepository.save(existingServiceRequest);
    }

    public RiskLevel evaluateRisk(int value) {
        return switch (value) {
            case 1, 2, 3 -> RiskLevel.LOW;
            case 4, 5, 6, 7 -> RiskLevel.MEDIUM;
            case 8, 9, 10 -> RiskLevel.HIGH;
            default -> throw new IllegalArgumentException("Value must be between 1 and 10");
        };
    }

    public List<ServiceRequest> getServiceRequestsByUserAndStatus(int userId, String status) {
        return serviceRequestRepository.findByUser_UserIdAndStatus(userId, status);
    }

    public List<ChemicalInHand> getChemicalsInHand(int userId, String status) {
        List<ServiceRequest> srs = serviceRequestRepository.findByUser_UserIdAndStatus(userId, status);
        return srs.stream()
                .map(serviceRequest -> new ChemicalInHand(
                        serviceRequest.getChemical().getChemicalId(),
                        serviceRequest.getResearch().getResearchId(),
                        serviceRequest.getSrId(),
                        serviceRequest.getQuantityRequested(),
                        serviceRequest.getChemical().getChemicalName(),
                        serviceRequest.getUnitOfQuantity()))
                .collect(Collectors.toList());
    }
}
