package com.wanderplan.wanderplan.dto;

import java.time.LocalDate;

public class TripDTO {
    private Long id;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long userId;  // just userId to avoid full User serialization
    private String userName; // 🌟 This is the new field

    // Constructors
    public TripDTO() {}

    public TripDTO(Long id, String destination, LocalDate startDate, LocalDate endDate, Long userId, String userName) {
        this.id = id;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
        this.userName = userName;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}
