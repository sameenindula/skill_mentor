package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDTO {

    private Integer sessionId;

    @NotBlank(message = "Session name is mandatory")
    private String sessionName;

    @NotBlank(message = "Start date is mandatory")
    private Integer startDate;

    @NotBlank(message = "End date is mandatory")
    private Integer endDate;

    @NotBlank(message = "Mentor is mandatory")
    private MentorDTO mentor;

    @NotBlank(message = "Student is mandatory")
    private StudentDTO student;

    @NotBlank(message = "Classroom is mandatory")
    private ClassRoomDTO classRoom;

    // No-argument constructor
    public SessionDTO() {
    }

    // Constructor with arguments
    public SessionDTO(Integer sessionId, String sessionName, Integer startDate, Integer endDate, MentorDTO mentor, StudentDTO student, ClassRoomDTO classRoom) {
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
    public MentorDTO getMentor() {
        return mentor;
    }
    public void setMentor(MentorDTO mentor) {
        this.mentor = mentor;
    }
    public StudentDTO getStudent() {
        return student;
    }
    public void setStudent(StudentDTO student) {
        this.student = student;
    }
    public ClassRoomDTO getClassRoom() {
        return classRoom;
    }
    public void setClassRoom(ClassRoomDTO classRoom) {
        this.classRoom = classRoom;
    }
}





