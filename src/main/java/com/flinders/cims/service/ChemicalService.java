package com.flinders.cims.service;

import com.flinders.cims.model.Chemical;
import com.flinders.cims.repository.ChemicalRepository;
import com.flinders.cims.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChemicalService {

    @Autowired
    private ChemicalRepository chemicalRepository;
    @Autowired
    private RandomNumber randomNumber;

    // Retrieve all chemicals
    public List<Chemical> getAllChemicals() {
        return chemicalRepository.findAll();
    }

    // Retrieve a single chemical by ID
    public Optional<Chemical> getChemicalById(int chemicalId) {
        return chemicalRepository.findById(chemicalId);
    }

    // Add a new chemical
    public Chemical createChemical(Chemical chemical) {
        // Check if a chemical with the same systematic name already exists
        Optional<Chemical> existingChemical = chemicalRepository.findBySystematicName(chemical.getSystematicName());
        if (existingChemical.isPresent()) {
            throw new IllegalArgumentException("Chemical with systematic name already exists");
        }
        int chemicalId = randomNumber.generateRandomNumber();
        while (chemicalRepository.findById(chemicalId).isPresent()) {
            chemicalId = randomNumber.generateRandomNumber();
        }
        chemical.setChemicalId(chemicalId);

        return chemicalRepository.save(chemical);
    }

    // Update an existing chemical
    public Chemical updateChemical(int chemicalId, Chemical updatedChemical) {
        return chemicalRepository.findById(chemicalId)
                .map(existingChemical -> {
                    existingChemical.setName(updatedChemical.getName() != null ? updatedChemical.getName() : existingChemical.getName());
                    existingChemical.setGenericRiskCategory(updatedChemical.getGenericRiskCategory() != null ? updatedChemical.getGenericRiskCategory() : existingChemical.getGenericRiskCategory());
                    existingChemical.setStorageRequirements(updatedChemical.getStorageRequirements() != null ? updatedChemical.getStorageRequirements() : existingChemical.getStorageRequirements());
                    existingChemical.setDisposalProcedure(updatedChemical.getDisposalProcedure() != null ? updatedChemical.getDisposalProcedure() : existingChemical.getDisposalProcedure());
                    existingChemical.setRiskLevel(updatedChemical.getRiskLevel() != null ? updatedChemical.getRiskLevel() : existingChemical.getRiskLevel());
                    return chemicalRepository.save(existingChemical);
                })
                .orElseThrow(() -> new RuntimeException("Chemical not found with id: " + chemicalId));
    }

    // Delete a chemical by ID
    public void deleteChemical(int chemicalId) {
        chemicalRepository.deleteById(chemicalId);
    }
    public Optional<Chemical> getChemicalByName(String name) {
        return chemicalRepository.findByName(name);
    }
    // Retrieve a single chemical by CAS number
    public Optional<Chemical> getChemicalByCasNumber(String casNumber) {
        return chemicalRepository.findByCasNumber(casNumber);
    }
}

