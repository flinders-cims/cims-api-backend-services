package com.flinders.cims.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chemicals")
public class Chemical{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chemical_id", nullable = false, unique = true)
    private int chemicalId;

    @Column(name = "chemical_name", nullable = false, length = 100)
    private String chemicalName;

    @Column(name = "generic_risk_category", length = 100)
    private String genericRiskCategory;

    @Column(name = "storage_requirements", columnDefinition = "TEXT")
    private String storageRequirements;

    @Column(name = "disposal_procedure", columnDefinition = "TEXT")
    private String disposalProcedure;

    @Enumerated(EnumType.STRING)
    @Column(name = "risk_level", nullable = false)
    private RiskLevel riskLevel;

    // Getters and Setters

    public int getChemicalId() {
        return chemicalId;
    }

    public void setChemicalId(int chemicalId) {
        this.chemicalId = chemicalId;
    }

    public String getName() {
        return chemicalName;
    }

    public void setName(String name) {
        this.chemicalName = name;
    }

    public String getGenericRiskCategory() {
        return genericRiskCategory;
    }

    public void setGenericRiskCategory(String genericRiskCategory) {
        this.genericRiskCategory = genericRiskCategory;
    }

    public String getStorageRequirements() {
        return storageRequirements;
    }

    public void setStorageRequirements(String storageRequirements) {
        this.storageRequirements = storageRequirements;
    }

    public String getDisposalProcedure() {
        return disposalProcedure;
    }

    public void setDisposalProcedure(String disposalProcedure) {
        this.disposalProcedure = disposalProcedure;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    // Enum for risk level
    public enum RiskLevel {
        LOW,
        MEDIUM,
        HIGH
    }
}
