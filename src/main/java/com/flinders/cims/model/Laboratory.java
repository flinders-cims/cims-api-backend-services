package com.flinders.cims.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "laboratories")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lab_id", nullable = false, unique = true)
    private int labId;

    @Column(name = "lab_name", nullable = false)
    private String labName;

    @ManyToOne
    @JoinColumn(name = "centre_id", nullable = false)
    private ResearchCenter researchCenter;

    @OneToMany(mappedBy = "laboratory", cascade = CascadeType.ALL)
    private List<StorageLocation> storageLocations;
}

