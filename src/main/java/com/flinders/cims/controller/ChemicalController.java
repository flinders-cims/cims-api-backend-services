package com.flinders.cims.controller;

import com.flinders.cims.model.Chemical;
import com.flinders.cims.service.ChemicalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cims/chemicals")
public class ChemicalController {

    @Autowired
    private ChemicalService chemicalService;

    @Operation(summary = "Retrieve all chemicals", description = "Fetches all chemicals in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of chemicals"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/all")
    public List<Chemical> getAllChemicals() {
        return chemicalService.getAllChemicals();
    }

    @Operation(summary = "Retrieve chemical by ID", description = "Fetches a chemical using its unique identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chemical found"),
            @ApiResponse(responseCode = "404", description = "Chemical not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/get/{id}")
    public ResponseEntity<Chemical> getChemicalById(@PathVariable("id") int id) {
        Optional<Chemical> chemical = chemicalService.getChemicalById(id);
        return chemical.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new chemical", description = "Adds a new chemical entry to the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chemical created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/add")
    public Chemical createChemical(@RequestBody Chemical chemical) {
        return chemicalService.createChemical(chemical);
    }

    @Operation(summary = "Update an existing chemical", description = "Updates the information of an existing chemical using its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chemical updated successfully"),
            @ApiResponse(responseCode = "404", description = "Chemical not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Chemical> updateChemical(@PathVariable("id") int id, @RequestBody Chemical updatedChemical) {
        try {
            Chemical chemical = chemicalService.updateChemical(id, updatedChemical);
            return ResponseEntity.ok(chemical);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a chemical", description = "Removes a chemical from the system using its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chemical deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Chemical not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChemical(@PathVariable("id") int id) {
        try {
            chemicalService.deleteChemical(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @Operation(summary = "Retrieve all chemicals for a given user", description = "Fetches all chemicals associated with a user.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of chemicals"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
//    @GetMapping("/getAll/{userId}")
//    public List<Chemical> getAllChemicalsByUserId(@PathVariable int userId) {
//        return chemicalService.getChemicalsByUserId(userId);
//    }
}

