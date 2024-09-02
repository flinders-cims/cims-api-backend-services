package com.flinders.cims.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chemicals")
public class Chemical {

    @Id
    @Column(name = "chemical_id")
    private String chemicalId;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "systematic_name")
    private String systematicName;

    @Column(name = "risk_category")
    private String genericRiskCategory;

    @Column(name = "cas_number")
    private String casNumber;

    public String getChemicalId() {
        return chemicalId;
    }

    public void setChemicalId(String chemicalId) {
        this.chemicalId = chemicalId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSystematicName() {
        return systematicName;
    }

    public void setSystematicName(String systematicName) {
        this.systematicName = systematicName;
    }

    public String getGenericRiskCategory() {
        return genericRiskCategory;
    }

    public void setGenericRiskCategory(String genericRiskCategory) {
        this.genericRiskCategory = genericRiskCategory;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public void setCasNumber(String casNumber) {
        this.casNumber = casNumber;
    }
}
