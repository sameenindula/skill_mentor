package com.example.demo.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.apache.logging.log4j.CloseableThreadContext.Instance;

import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDTO {

    private Integer sessionId;

    @NotBlank(message = "Topic is mandatory")
    private String topic;

    @NotBlank(message = "Session name is mandatory")
    private String sessionName;

    @NotBlank(message = "Start date is mandatory")
    private Instant startDate;

    @NotBlank(message = "End date is mandatory")
    private Instant endDate;

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
    public SessionDTO(String topic,Integer sessionId, String sessionName, Instant startDate, Instant endDate, MentorDTO mentor, StudentDTO student, ClassRoomDTO classRoom) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mentor = mentor;
        this.student = student;
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

    public Instant getStartDate() {
        return startDate;
    }
    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }
    public Instant getEndDate() {
        return endDate;
    }
    public void setEndDate(Instant endDate) {
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
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
}





