package com.flinders.cims.service;

import com.flinders.cims.model.ResearchCenter;
import com.flinders.cims.repository.ResearchCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchCenterService {

    @Autowired
    private ResearchCenterRepository researchCenterRepository;

    public List<ResearchCenter> getAllResearchCenters() {
        return researchCenterRepository.findAll();
    }

    public Optional<ResearchCenter> getResearchCenterById(int id) {
        return researchCenterRepository.findById(id);
    }

    public ResearchCenter createResearchCenter(ResearchCenter researchCenter) {
        return researchCenterRepository.save(researchCenter);
    }

    public ResearchCenter updateResearchCenter(int id, ResearchCenter updatedResearchCenter) {
        return researchCenterRepository.findById(id)
                .map(existingResearchCenter -> {
                    existingResearchCenter.setName(updatedResearchCenter.getName());
                    return researchCenterRepository.save(existingResearchCenter);
                })
                .orElseThrow(() -> new RuntimeException("Research Center not found"));
    }

    public void deleteResearchCenter(int id) {
        researchCenterRepository.deleteById(id);
    }
}
