package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "classroom")

public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classRoomId;

    @Column(name = "title")
    private String title;

    @Column(name = "session_fee")
    private Double sessionFee;

    @Column(name = "enroll_student_count")
    private Integer enrollStudentCount;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "mentor_id")
    private MentorEntity mentor;

    public MentorEntity getMentor() {
        return mentor;
    }
    public void setMentor(MentorEntity mentor) {
        this.mentor = mentor;
    }




    public ClassRoomEntity() {
    }
    public ClassRoomEntity(Integer classRoomId, String title, Double sessionFee, Integer enrollStudentCount, MentorEntity mentor) {
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



    
}

