package com.example.demo.entity;

import java.time.Instant;

import org.apache.logging.log4j.CloseableThreadContext.Instance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "session")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer sessionId;

    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "session_topic")
    private String sessionTopic;

    @Column(name = "start_date")
    private Instant startDate;
    
    @Column(name = "end_date")
    private Instant endDate;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "mentor_id")
    private MentorEntity mentor;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "classroom_id")
    private ClassRoomEntity classroom;


    public SessionEntity() {
    }
    public SessionEntity(Integer sessionId, String sessionName, Instant startDate, Instant endDate, MentorEntity mentor, StudentEntity student, ClassRoomEntity classroom, String sessionTopic) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sessionTopic = sessionTopic;
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

    public String getSessionTopic() {
        return sessionTopic;
    }

    public void setSessionTopic(String sessionTopic) {
        this.sessionTopic = sessionTopic;
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

    public MentorEntity getMentor() {
        return mentor;
    }

    public void setMentor(MentorEntity mentor) {
        this.mentor = mentor;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public ClassRoomEntity getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassRoomEntity classroom) {
        this.classroom = classroom;
    }

}