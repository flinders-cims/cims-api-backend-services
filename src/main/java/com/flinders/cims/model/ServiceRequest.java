package com.flinders.cims.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "date_closed")
    private LocalDate dateClosed;

    @Column(name = "approver_comments", columnDefinition = "TEXT")
    private String approverComments;

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

    // Getters and Setters
    //...
}

