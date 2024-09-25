package com.flinders.cims.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "research_centers")
public class ResearchCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "center_id", nullable = false, unique = true)
    private int centerId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = false)
    private Institute institute;

    @OneToMany(mappedBy = "researchCenter", cascade = CascadeType.ALL)
    private List<Laboratory> laboratories;

    @OneToMany(mappedBy = "researchCenter", cascade = CascadeType.ALL)
    private List<StorageLocation> storageLocations;
}

