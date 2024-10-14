package com.flinders.cims.controller;

import com.flinders.cims.model.Research;
import com.flinders.cims.model.ResearchDTO;
import com.flinders.cims.service.ResearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cims/research")
public class ResearchController {

    @Autowired
    private ResearchService researchService;

    @Operation(summary = "Create a new research", description = "Create a new research entry in the system for a given user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Research created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/add/{userId}")
    public ResponseEntity<Research> createResearch(@PathVariable int userId, @RequestBody ResearchDTO research) {
        Research createdResearch = researchService.createResearch(userId, research);
        return ResponseEntity.ok(createdResearch);
    }

    @Operation(summary = "Get all researches", description = "Retrieve a list of all researches available in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Researches retrieved successfully"),
            @ApiResponse(responseCode = "204", description = "No researches found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/getAll")
    public ResponseEntity<List<Research>> getAllResearches() {
        List<Research> researches = researchService.getAllResearches();
        return ResponseEntity.ok(researches);
    }

    @Operation(summary = "Get a research by ID", description = "Retrieve a research by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Research found"),
            @ApiResponse(responseCode = "404", description = "Research not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/get/{id}")
    public ResponseEntity<Research> getResearchById(@PathVariable int id) {
        Research research = researchService.getResearchById(id);
        if (research != null) {
            return ResponseEntity.ok(research);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Update a research", description = "Update an existing research entry by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Research updated successfully"),
            @ApiResponse(responseCode = "404", description = "Research not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Research> updateResearch(@PathVariable int id, @RequestBody Research updatedResearch) {
        Research research = researchService.updateResearch(id, updatedResearch);
        if (research != null) {
            return ResponseEntity.ok(research);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a research", description = "Delete a research entry by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Research deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Research not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResearch(@PathVariable int id) {
        researchService.deleteResearch(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Retrieve all researches for a given user", description = "Fetches all researches associated with a user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of researches"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/getAll/{userId}")
    public ResponseEntity<Object>  getAllResearchesByUserId(@PathVariable int userId) {
        List<Research> researchList = researchService.getResearchesByUserId(userId);
        if (researchList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ID not Found"); // No research found, return 404
        }

        return ResponseEntity.ok(researchList);
    }

    @Operation(summary = "Get the count of researches for a given user", description = "Fetches the total number of researches associated with a user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the count of researches"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/getCount/{userId}")
    public ResponseEntity<Object> getResearchCountByUserId(@PathVariable int userId) {
        long researchCount = researchService.getResearchCountByUserId(userId);
        if (researchCount == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No research found for this User ID");
        }

        return ResponseEntity.ok(researchCount);
    }
}
