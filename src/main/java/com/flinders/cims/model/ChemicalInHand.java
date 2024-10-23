package com.flinders.cims.model;

public class ChemicalInHand {

    private int chemicalId;           // Unique ID for the chemical
    private int researchId;           // ID for the research project
    private int srId;                 // ID for the service request
    private int quantity;             // Quantity of the chemical in hand
    private String chemicalName;      // Name of the chemical
    private String unitOfQuantity;    // Unit for measuring the quantity
    private String genericRiskCategory;

    public String getGenericRiskCategory() {
        return genericRiskCategory;
    }

    public void setGenericRiskCategory(String genericRiskCategory) {
        this.genericRiskCategory = genericRiskCategory;
    }

    // Constructors
    public ChemicalInHand() {
    }

    public ChemicalInHand(int chemicalId, int researchId, int srId, int quantity, String chemicalName, String unitOfQuantity, String genericRiskCategory) {
        this.chemicalId = chemicalId;
        this.researchId = researchId;
        this.srId = srId;
        this.quantity = quantity;
        this.chemicalName = chemicalName;
        this.unitOfQuantity = unitOfQuantity;
        this.genericRiskCategory = genericRiskCategory;
    }

    // Getters and Setters
    public int getChemicalId() {
        return chemicalId;
    }

    public void setChemicalId(int chemicalId) {
        this.chemicalId = chemicalId;
    }

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public int getSrId() {
        return srId;
    }

    public void setSrId(int srId) {
        this.srId = srId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getUnitOfQuantity() {
        return unitOfQuantity;
    }

    public void setUnitOfQuantity(String unitOfQuantity) {
        this.unitOfQuantity = unitOfQuantity;
    }
}

