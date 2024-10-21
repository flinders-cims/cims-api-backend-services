package com.flinders.cims.controller;

import com.flinders.cims.model.ResearchCenter;
import com.flinders.cims.service.ResearchCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/research-centers")
public class ResearchCenterController {

    @Autowired
    private ResearchCenterService researchCenterService;

    @GetMapping
    public List<ResearchCenter> getAllResearchCenters() {
        return researchCenterService.getAllResearchCenters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResearchCenter> getResearchCenterById(@PathVariable int id) {
        return researchCenterService.getResearchCenterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResearchCenter createResearchCenter(@RequestBody ResearchCenter researchCenter) {
        return researchCenterService.createResearchCenter(researchCenter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResearchCenter> updateResearchCenter(@PathVariable int id, @RequestBody ResearchCenter researchCenter) {
        return ResponseEntity.ok(researchCenterService.updateResearchCenter(id, researchCenter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResearchCenter(@PathVariable int id) {
        researchCenterService.deleteResearchCenter(id);
        return ResponseEntity.noContent().build();
    }
}
