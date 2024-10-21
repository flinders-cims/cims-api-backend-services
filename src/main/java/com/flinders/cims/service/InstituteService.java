package com.flinders.cims.service;

import com.flinders.cims.model.Institute;
import com.flinders.cims.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }

    public Optional<Institute> getInstituteById(int id) {
        return instituteRepository.findById(id);
    }

    public Institute createInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    public Institute updateInstitute(int id, Institute updatedInstitute) {
        return instituteRepository.findById(id)
                .map(existingInstitute -> {
                    existingInstitute.setName(updatedInstitute.getName());
                    return instituteRepository.save(existingInstitute);
                })
                .orElseThrow(() -> new RuntimeException("Institute not found"));
    }

    public void deleteInstitute(int id) {
        instituteRepository.deleteById(id);
    }
}
