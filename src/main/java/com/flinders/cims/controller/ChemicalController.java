package com.flinders.cims.controller;

import com.flinders.cims.model.Chemical;
import com.flinders.cims.service.ChemicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chemicals")
public class ChemicalController {

    @Autowired
    private ChemicalService chemicalService;

    @PostMapping
    public Chemical addChemical(@RequestBody Chemical chemical) {
        return chemicalService.addChemical(chemical);
    }

    @GetMapping
    public List<Chemical> getAllChemicals() {
        return chemicalService.getAllChemicals();
    }
}
