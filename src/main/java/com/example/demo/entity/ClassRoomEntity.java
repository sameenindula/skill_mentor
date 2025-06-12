package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "classroom")

public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classRoomId;

    @Column(name = "title",nullable=false)
    @NotBlank(message = "title should not be blank")
    private String title;


    @Column(name = "enroll_student_count", nullable=false)
    @jakarta.validation.constraints.NotNull(message = "enroll student count should not be null")
    private Integer enrollStudentCount;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "mentor_id")
    private MentorEntity mentor;

    @OneToMany(mappedBy = "classroom")
    private List<SessionEntity> sessions;


    public ClassRoomEntity() {
    }
    public ClassRoomEntity(Integer classRoomId, String title, Integer enrollStudentCount, MentorEntity mentor, List<SessionEntity> sessions) {
        this.classRoomId = classRoomId;
        this.title = title;
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


    public Integer getEnrollStudentCount() {
        return enrollStudentCount;
    }

    public void setEnrollStudentCount(Integer enrollStudentCount) {
        this.enrollStudentCount = enrollStudentCount;
    }
    public MentorEntity getMentor() {
        return mentor;
    }
    public void setMentor(MentorEntity mentor) {
        this.mentor = mentor;
    }
    public List<SessionEntity> getSessions() {
        return sessions;
    }
    public void setSessions(List<SessionEntity> sessions) {
        this.sessions = sessions;
    }


    
}

