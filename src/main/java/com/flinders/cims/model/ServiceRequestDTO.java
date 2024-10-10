package com.flinders.cims.model;

import java.time.LocalDate;

public class ServiceRequestDTO {
    private int userId;
    private int chemicalId;
    private int researchId;
    private String status;
    private RiskLevel riskLevel;
    private LocalDate dateRequested;
    private LocalDate dateApproved;
    private LocalDate dateClosed;
    private String approverUsername;
    private String approverComments;
    private int quantityRequested;
    private int quantityReceived;
    private String unitOfQuantity;
    private int quantityDisposed;
    private int quantityReturned;
    private LocalDate returnedDate;
    private int storageLocationId;
    private int riskScore;
    private String casNumber;
    private String hazardType;
    private boolean isToxic;
    private String toxicEffect;

    public int getUserId() {
        return userId;
    }

    public int getChemicalId() {
        return chemicalId;
    }

    public int getResearchId() {
        return researchId;
    }

    public String getStatus() {
        return status;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public LocalDate getDateRequested() {
        return dateRequested;
    }

    public LocalDate getDateApproved() {
        return dateApproved;
    }

    public LocalDate getDateClosed() {
        return dateClosed;
    }

    public String getApproverUsername() {
        return approverUsername;
    }

    public String getApproverComments() {
        return approverComments;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    public int getQuantityReceived() {
        return quantityReceived;
    }

    public String getUnitOfQuantity() {
        return unitOfQuantity;
    }

    public int getQuantityDisposed() {
        return quantityDisposed;
    }

    public int getQuantityReturned() {
        return quantityReturned;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public int getStorageLocationId() {
        return storageLocationId;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public String getHazardType() {
        return hazardType;
    }

    public boolean isToxic() {
        return isToxic;
    }

    public String getToxicEffect() {
        return toxicEffect;
    }
}
