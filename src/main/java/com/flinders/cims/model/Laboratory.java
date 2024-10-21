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

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public ResearchCenter getResearchCenter() {
        return researchCenter;
    }

    public void setResearchCenter(ResearchCenter researchCenter) {
        this.researchCenter = researchCenter;
    }

    public List<StorageLocation> getStorageLocations() {
        return storageLocations;
    }

    public void setStorageLocations(List<StorageLocation> storageLocations) {
        this.storageLocations = storageLocations;
    }
}

