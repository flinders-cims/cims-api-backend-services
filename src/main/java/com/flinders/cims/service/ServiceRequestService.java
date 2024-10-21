package com.flinders.cims.service;

import com.flinders.cims.model.*;
import com.flinders.cims.repository.ServiceRequestRepository;
import com.flinders.cims.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if(chemical == null) {
            chemical = chemicalService.getChemicalByCasNumber(serviceRequestDTO.getCasNumber()).orElse(null);
        }
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

    public ServiceRequest updateServiceRequest(ServiceRequest existingServiceRequest,ServiceRequest serviceRequest) {
        existingServiceRequest.setStatus(serviceRequest.getStatus());
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
}
