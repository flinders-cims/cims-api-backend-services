package com.flinders.cims.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "institutes")
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institute_id", nullable = false, unique = true)
    private int instituteId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "institute", cascade = CascadeType.ALL)
    private List<ResearchCenter> researchCenters;

    @OneToMany(mappedBy = "institute", cascade = CascadeType.ALL)
    private List<StorageLocation> storageLocations;

    // Getters and Setters
}

