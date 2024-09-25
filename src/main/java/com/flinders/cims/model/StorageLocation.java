package com.flinders.cims.model;
import jakarta.persistence.*;
@Entity
@Table(name = "storage_locations")
public class StorageLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storage_id", nullable = false, unique = true)
    private int storageId;

    @Column(name = "storage_name", nullable = false)
    private String storageName;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "current_quantity", nullable = false)
    private int currentQuantity;

    @Column(name = "risk_level", nullable = false)
    private String riskLevel;

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = true)
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "centre_id", nullable = true)
    private ResearchCenter researchCenter;

    @ManyToOne
    @JoinColumn(name = "lab_id", nullable = true)
    private Laboratory laboratory;
}

