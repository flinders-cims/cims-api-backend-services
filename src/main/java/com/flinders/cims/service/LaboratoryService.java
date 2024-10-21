package com.flinders.cims.service;

import com.flinders.cims.model.Laboratory;
import com.flinders.cims.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public List<Laboratory> getAllLaboratories() {
        return laboratoryRepository.findAll();
    }

    public Optional<Laboratory> getLaboratoryById(int id) {
        return laboratoryRepository.findById(id);
    }

    public Laboratory createLaboratory(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }

    public Laboratory updateLaboratory(int id, Laboratory updatedLaboratory) {
        return laboratoryRepository.findById(id)
                .map(existingLaboratory -> {
                    existingLaboratory.setLabName(updatedLaboratory.getLabName());
                    return laboratoryRepository.save(existingLaboratory);
                })
                .orElseThrow(() -> new RuntimeException("Laboratory not found"));
    }

    public void deleteLaboratory(int id) {
        laboratoryRepository.deleteById(id);
    }
}
