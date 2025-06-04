package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class PaymentDTO {
    @NotNull(message = "mentor id should not be null")
    private Integer mentorId;

    @NotBlank(message = "mentor name should not be blank")
    private String mentorName;

    @NotNull(message = "total fee should not be null")
    private Double totalFee;

    public PaymentDTO() {
    }

    public PaymentDTO(Integer mentorId, String mentorName, Double totalFee) {
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.totalFee = totalFee;
    }
    public Integer getMentorId() {
        return mentorId;
    }
    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }
    public String getMentorName() {
        return mentorName;
    }
    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }
    public Double getTotalFee() {
        return totalFee;
    }
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
    
    
}
