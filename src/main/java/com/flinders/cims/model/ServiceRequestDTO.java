package com.flinders.cims.model;

import java.time.LocalDate;

public class ServiceRequestDTO {
    private int userId;
    private String chemicalName;
    private String researchTitle;
    private String status;
    private int riskLevel;
    private LocalDate dateRequested;
    private LocalDate dateApproved;
    private LocalDate dateRejected;
    private LocalDate dateClosed;
    private String approverUsername;
    private String approverComments;
    private int quantityRequested;
    private int quantityApproved;
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
    private String approverComment;
    private boolean isStored;
    private boolean isDisposed;
    private boolean isSentFromSupervisor;

    public int getUserId() {
        return userId;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public String getResearchTitle() {
        return researchTitle;
    }
    public String getStatus() {
        return status;
    }

    public int getRiskLevel() {
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
        return quantityApproved;
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

    public LocalDate getDateRejected() {
        return dateRejected;
    }

    public int getQuantityApproved() {
        return quantityApproved;
    }

    public String getApproverComment() {
        return approverComment;
    }

    public boolean isStored() {
        return isStored;
    }

    public boolean isDisposed() {
        return isDisposed;
    }

    public boolean isSentFromSupervisor() {
        return isSentFromSupervisor;
    }

    public void setSentFromSupervisor(boolean sentFromSupervisor) {
        isSentFromSupervisor = sentFromSupervisor;
    }
}
