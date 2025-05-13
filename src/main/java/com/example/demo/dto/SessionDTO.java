package com.example.demo.dto;

public class SessionDTO {
    private Integer sessionId;
    private String sessionName;
    private Integer startDate;
    private Integer endDate;

    // No-argument constructor
    public SessionDTO() {
    }

    // Constructor with arguments
    public SessionDTO(Integer sessionId, String sessionName, Integer startDate, Integer endDate) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters
    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }
}





