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

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResearchCenter> getResearchCenters() {
        return researchCenters;
    }

    public void setResearchCenters(List<ResearchCenter> researchCenters) {
        this.researchCenters = researchCenters;
    }

    public List<StorageLocation> getStorageLocations() {
        return storageLocations;
    }

    public void setStorageLocations(List<StorageLocation> storageLocations) {
        this.storageLocations = storageLocations;
    }
}

