package com.flinders.cims.service;

import com.flinders.cims.model.Research;
import com.flinders.cims.model.ResearchDTO;
import com.flinders.cims.model.ResearchStatus;
import com.flinders.cims.model.User;
import com.flinders.cims.repository.ResearchRepository;
import com.flinders.cims.repository.UserRepository;
import com.flinders.cims.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ResearchService {

    @Autowired
    private ResearchRepository researchRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RandomNumber randomNumber;

    @Autowired
    private UserRepository userRepo;

    public Research createResearch(int userId, ResearchDTO researchDTO) {
        User user = userRepo.findById(userId).orElse(null);
        Research research = new Research();
        LocalDate today = LocalDate.now();
        research.setResearchId(randomNumber.generateRandomNumber());
        if(!researchDTO.getStartDate().isAfter(today))
            research.setStatus(ResearchStatus.ACTIVE);
        else
            research.setStatus(ResearchStatus.INACTIVE);
        research.setUser(user);
        research.setTitle(researchDTO.getTitle());
        research.setDescription(researchDTO.getDescription());
        research.setStartDate(researchDTO.getStartDate());
        research.setExpectedEndDate(researchDTO.getExpectedEndDate());
        return researchRepository.save(research);
    }

    public List<Research> getAllResearches() {
        List<Research> researches = researchRepository.findAll();
        researches.forEach(research -> {
            if (research.getUser() != null) {
                research.getUser().setPassword("*********");
            }
        });
        return researches;
    }

    public Research getResearchById(int researchId) {
        Research research = researchRepository.findById(researchId).orElse(null);
        if (research != null) {
            research.getUser().setPassword("*********");
        }
        return research;
    }

    public Research updateResearch(int researchId, Research updatedResearch) {
        return researchRepository.findById(researchId)
                .map(research -> {
                    if (updatedResearch.getTitle() != null) {
                        research.setTitle(updatedResearch.getTitle());
                    }
                    if (updatedResearch.getDescription() != null) {
                        research.setDescription(updatedResearch.getDescription());
                    }
                    if (updatedResearch.getStartDate() != null) {
                        research.setStartDate(updatedResearch.getStartDate());
                    }
                    if (updatedResearch.getExpectedEndDate() != null) {
                        research.setExpectedEndDate(updatedResearch.getExpectedEndDate());
                    }
                    // Save the updated research entity
                    return researchRepository.save(research);
                })
                .orElse(null);  // Return null if research not found
    }

    public void deleteResearch(int researchId) {
        researchRepository.deleteById(researchId);
    }

    public List<Research> getResearchesByUserId(int userId) {
        if (userRepository.findById(userId).isPresent()) {
            List<Research> researches = researchRepository.findByUser_UserId(userId);
            researches.forEach(research -> research.setUser(null));
            return researches;
        } else return null;
    }

    public long getResearchCountByUserId(int userId) {
        return researchRepository.findByUser_UserId(userId).stream().count();
    }

    public Research getResearchByTitle(String title) {
        return researchRepository.findByTitle(title);
    }
}

