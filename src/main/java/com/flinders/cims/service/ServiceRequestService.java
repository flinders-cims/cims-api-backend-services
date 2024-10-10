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
        Chemical chemical = chemicalService.getChemicalById(serviceRequestDTO.getChemicalId()).orElse(null);
        Research research = researchService.getResearchById(serviceRequestDTO.getResearchId());
        User user = userService.getUserById(serviceRequestDTO.getUserId());
        serviceRequest.setUser(user);
        serviceRequest.setResearch(research);
        serviceRequest.setChemical(chemical);
        serviceRequest.setStatus(serviceRequestDTO.getStatus());
        serviceRequest.setStatus(serviceRequestDTO.getStatus());
        serviceRequest.setStatus(serviceRequestDTO.getStatus());
        serviceRequest.setRiskLevel(serviceRequestDTO.getRiskLevel());
        serviceRequest.setDateRequested(serviceRequestDTO.getDateRequested());
        serviceRequest.setDateApproved(serviceRequestDTO.getDateApproved());
        serviceRequest.setDateClosed(serviceRequestDTO.getDateClosed());
        serviceRequest.setApproverUsername(serviceRequestDTO.getApproverUsername());
        serviceRequest.setApproverComments(serviceRequestDTO.getApproverComments());
        serviceRequest.setQuantityRequested(serviceRequestDTO.getQuantityRequested());
        serviceRequest.setQuantityReceived(serviceRequestDTO.getQuantityReceived());
        serviceRequest.setUnitOfQuantity(serviceRequestDTO.getUnitOfQuantity());
        serviceRequest.setQuantityDisposed(serviceRequestDTO.getQuantityDisposed());
        serviceRequest.setQuantityReturned(serviceRequestDTO.getQuantityReturned());
        serviceRequest.setReturnedDate(serviceRequestDTO.getReturnedDate());
        serviceRequest.setRiskScore(serviceRequestDTO.getRiskScore());
        serviceRequest.setCasNumber(serviceRequestDTO.getCasNumber());
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
}
