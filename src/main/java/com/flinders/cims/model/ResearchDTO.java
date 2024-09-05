package com.flinders.cims.model;

import java.time.LocalDate;

public class ResearchDTO {

    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate expectedEndDate;

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExpectedEndDate() {
        return expectedEndDate;
    }
}
