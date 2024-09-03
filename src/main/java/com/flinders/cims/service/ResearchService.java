package com.flinders.cims.service;


import com.flinders.cims.model.Research;
import com.flinders.cims.repository.ResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchService {

    @Autowired
    private ResearchRepository researchRepository;

    public Research createResearch(Research research) {
        return researchRepository.save(research);
    }

    public List<Research> getAllResearches() {
        return researchRepository.findAll();
    }

    public Research getResearchById(int researchId) {
        return researchRepository.findById(researchId).orElse(null);
    }

    public Research updateResearch(int researchId, Research updatedResearch) {
        return researchRepository.findById(researchId)
                .map(research -> {
                    research.setTitle(updatedResearch.getTitle());
                    research.setDescription(updatedResearch.getDescription());
                    research.setStartDate(updatedResearch.getStartDate());
                    research.setExpectedEndDate(updatedResearch.getExpectedEndDate());
                    research.setEndDate(updatedResearch.getEndDate());
                    research.setStatus(updatedResearch.getStatus());
                    research.setUser(updatedResearch.getUser());
                    return researchRepository.save(research);
                })
                .orElse(null);
    }

    public void deleteResearch(int researchId) {
        researchRepository.deleteById(researchId);
    }
}

