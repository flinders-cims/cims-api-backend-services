package com.flinders.cims.controller;

import com.flinders.cims.model.Institute;
import com.flinders.cims.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institutes")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @GetMapping
    public List<Institute> getAllInstitutes() {
        return instituteService.getAllInstitutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable int id) {
        return instituteService.getInstituteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Institute createInstitute(@RequestBody Institute institute) {
        return instituteService.createInstitute(institute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable int id, @RequestBody Institute institute) {
        return ResponseEntity.ok(instituteService.updateInstitute(id, institute));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitute(@PathVariable int id) {
        instituteService.deleteInstitute(id);
        return ResponseEntity.noContent().build();
    }
}
