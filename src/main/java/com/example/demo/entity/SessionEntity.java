package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "session")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer sessionId;

    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "start_date")
    private Integer startDate;
    
    @Column(name = "end_date")
    private Integer endDate;


    public SessionEntity() {
    }
    public SessionEntity(Integer sessionId, String sessionName, Integer startDate, Integer endDate) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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
