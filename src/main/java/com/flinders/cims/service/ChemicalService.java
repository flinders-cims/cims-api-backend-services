package com.flinders.cims.service;

import com.flinders.cims.model.Chemical;
import com.flinders.cims.repository.ChemicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChemicalService {

    @Autowired
    private ChemicalRepository chemicalRepository;

    public Chemical addChemical(Chemical chemical) {
        String chemicalId = generateChemicalId(chemical.getCommonName(), chemical.getCasNumber());
        chemical.setChemicalId(chemicalId);
        return chemicalRepository.save(chemical);
    }

    public List<Chemical> getAllChemicals() {
        return chemicalRepository.findAll();
    }

    public String generateChemicalId(String commonName, String casNumber) {
        // Extract the first three letters of the commonName
        String namePart = commonName.length() >= 3 ? commonName.substring(0, 3).toUpperCase() : commonName.toUpperCase();
        // Concatenate with the casNumber
        return namePart + casNumber.replaceAll("-", "");
    }
}
