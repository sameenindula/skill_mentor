package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
    
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassRoomDTO {
    private Integer classRoomId;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message="SessionFee is mandatory")
    private Double sessionFee;

    @NotBlank(message="EnrollStudentCount is mandatory")
    private Integer enrollStudentCount;

    @NotBlank(message="Mentor is mandatory")
    private MentorDTO mentor;


    public ClassRoomDTO() {
    }

    public ClassRoomDTO(Integer classRoomId, String title, Double sessionFee, Integer enrollStudentCount, MentorDTO mentor) {
        this.classRoomId = classRoomId;
        this.title = title;
        this.sessionFee = sessionFee;
        this.enrollStudentCount = enrollStudentCount;
        this.mentor = mentor;
    }

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSessionFee() {
        return sessionFee;
    }

    public void setSessionFee(Double sessionFee) {
        this.sessionFee = sessionFee;
    }

    public Integer getEnrollStudentCount() {
        return enrollStudentCount;
    }

    public void setEnrollStudentCount(Integer enrollStudentCount) {
        this.enrollStudentCount = enrollStudentCount;
    }

    public MentorDTO getMentor() {
        return mentor;
    }

    public void setMentor(MentorDTO mentor) {
        this.mentor = mentor;
    }
}

