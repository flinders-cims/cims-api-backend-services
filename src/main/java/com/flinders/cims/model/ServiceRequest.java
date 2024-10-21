package com.flinders.cims.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @Column(name = "sr_id", nullable = false, unique = true)
    private int srId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Link to Research Staff (User) table
    private User user;

    @ManyToOne
    @JoinColumn(name = "chemical_id", nullable = false)  // Link to Chemicals table
    private Chemical chemical;

    @ManyToOne
    @JoinColumn(name = "research_id", nullable = false)  // Link to Research table
    private Research research;

    @Column(name = "status", nullable = false)
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(name = "risk_level", nullable = false)
    private RiskLevel riskLevel;

    @Column(name = "date_requested", nullable = false)
    private LocalDate dateRequested;

    @Column(name = "date_approved")
    private LocalDate dateApproved;

    @Column(name = "date_rejected")
    private LocalDate dateRejected;

    @Column(name = "date_closed")
    private LocalDate dateClosed;

    @Column(name = "approver_user_name", columnDefinition = "TEXT")
    private String approverUsername;

    @Column(name = "approver_comment", columnDefinition = "TEXT")
    private String approverComment;

    @Column(name = "quantity_requested", nullable = false)
    private int quantityRequested;

    @Column(name = "quantity_received")
    private int quantityReceived;

    @Column(name = "unit_of_quantity", nullable = false)
    private String unitOfQuantity;

    @Column(name = "quantity_disposed")
    private int quantityDisposed;

    @Column(name = "quantity_returned")
    private int quantityReturned;

    @Column(name = "returned_date")
    private LocalDate returnedDate;

    @ManyToOne
    @JoinColumn(name = "storage_location_id")  // Link to Storage Locations table
    private StorageLocation storageLocation;

    @Column(name = "risk_score", nullable = false)
    private int riskScore;  // Dropdown with values from 0 to 10

    @Column(name = "cas_number", nullable = false)
    private String casNumber;  // CAS Number for the chemical

    @Column(name = "hazard_type", nullable = false)
    private String hazardType;  // Dropdown for hazard types

    @Column(name = "is_toxic", nullable = false)
    private boolean isToxic;  // Yes or No dropdown

    @Column(name = "toxic_effect", columnDefinition = "TEXT")
    private String toxicEffect;  // Dropdown with values if toxic

    @Column(name = "is_stored", nullable = false)
    private boolean isStored;  // Newly added field for storage status

    @Column(name = "is_disposed", nullable = false)
    private boolean isDisposed;  // Newly added field for disposal status

    // Getters and Setters

    public int getSrId() {
        return srId;
    }

    public void setSrId(int srId) {
        this.srId = srId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chemical getChemical() {
        return chemical;
    }

    public void setChemical(Chemical chemical) {
        this.chemical = chemical;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public LocalDate getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(LocalDate dateRequested) {
        this.dateRequested = dateRequested;
    }

    public LocalDate getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(LocalDate dateApproved) {
        this.dateApproved = dateApproved;
    }

    public LocalDate getDateRejected() {
        return dateRejected;
    }

    public void setDateRejected(LocalDate dateRejected) {
        this.dateRejected = dateRejected;
    }

    public LocalDate getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDate dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getApproverUsername() {
        return approverUsername;
    }

    public void setApproverUsername(String approverUsername) {
        this.approverUsername = approverUsername;
    }

    public String getApproverComment() {
        return approverComment;
    }

    public void setApproverComment(String approverComment) {
        this.approverComment = approverComment;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(int quantityRequested) {
        this.quantityRequested = quantityRequested;
    }

    public int getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(int quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public String getUnitOfQuantity() {
        return unitOfQuantity;
    }

    public void setUnitOfQuantity(String unitOfQuantity) {
        this.unitOfQuantity = unitOfQuantity;
    }

    public int getQuantityDisposed() {
        return quantityDisposed;
    }

    public void setQuantityDisposed(int quantityDisposed) {
        this.quantityDisposed = quantityDisposed;
    }

    public int getQuantityReturned() {
        return quantityReturned;
    }

    public void setQuantityReturned(int quantityReturned) {
        this.quantityReturned = quantityReturned;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public StorageLocation getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(StorageLocation storageLocation) {
        this.storageLocation = storageLocation;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public void setCasNumber(String casNumber) {
        this.casNumber = casNumber;
    }

    public String getHazardType() {
        return hazardType;
    }

    public void setHazardType(String hazardType) {
        this.hazardType = hazardType;
    }

    public boolean isToxic() {
        return isToxic;
    }

    public void setToxic(boolean toxic) {
        isToxic = toxic;
    }

    public String getToxicEffect() {
        return toxicEffect;
    }

    public void setToxicEffect(String toxicEffect) {
        this.toxicEffect = toxicEffect;
    }

    public boolean isStored() {
        return isStored;
    }

    public void setStored(boolean stored) {
        isStored = stored;
    }

    public boolean isDisposed() {
        return isDisposed;
    }

    public void setDisposed(boolean disposed) {
        isDisposed = disposed;
    }
}
