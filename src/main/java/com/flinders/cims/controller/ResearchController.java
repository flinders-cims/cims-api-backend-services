package com.flinders.cims.controller;

import com.flinders.cims.model.Research;
import com.flinders.cims.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cims")
public class ResearchController {

    @Autowired
    private ResearchService researchService;

    @PostMapping("/research/add")
    public ResponseEntity<Research> createResearch(@RequestBody Research research) {
        Research createdResearch = researchService.createResearch(research);
        return ResponseEntity.ok(createdResearch);
    }

    @GetMapping("/research/getAll")
    public ResponseEntity<List<Research>> getAllResearches() {
        List<Research> researches = researchService.getAllResearches();
        return ResponseEntity.ok(researches);
    }

    @GetMapping("/research/get/{id}")
    public ResponseEntity<Research> getResearchById(@PathVariable int id) {
        Research research = researchService.getResearchById(id);
        if (research != null) {
            return ResponseEntity.ok(research);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/research/update/{id}")
    public ResponseEntity<Research> updateResearch(@PathVariable int id, @RequestBody Research updatedResearch) {
        Research research = researchService.updateResearch(id, updatedResearch);
        if (research != null) {
            return ResponseEntity.ok(research);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/research/delete/{id}")
    public ResponseEntity<Void> deleteResearch(@PathVariable int id) {
        researchService.deleteResearch(id);
        return ResponseEntity.noContent().build();
    }
}
