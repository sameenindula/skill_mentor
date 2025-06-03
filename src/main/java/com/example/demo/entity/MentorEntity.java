package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "mentor")

public class MentorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "title")
    private String title;

    @Column(name = "profession")
    private String profession;

    @Column(name = "subject")
    private String subject;

    @Column(name = "qualification")
    private String qualification;

    @OneToOne(mappedBy = "mentor")
    private ClassRoomEntity classroom;

    @OneToMany(mappedBy = "mentor")
    private  List<SessionEntity> sessions;

    @Column(name = "sessionFee")
    private Double sessionFee;

    

 

    public MentorEntity(Integer mentorId, String firstName, String lastName, String address, String email, String title,
            String profession, String subject, String qualification, ClassRoomEntity classroom, List<SessionEntity> sessions,Double sessionFee) {
        this.mentorId = mentorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.title = title;
        this.profession = profession;
        this.subject = subject;
        this.qualification = qualification;
        this.classroom = classroom;
        this.sessions = sessions;
        this.sessionFee = sessionFee;
    }  

    public MentorEntity() {
    }

    

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public ClassRoomEntity getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassRoomEntity classroom) {
        this.classroom = classroom;
    }

    public List<SessionEntity> getSessions() {
        return sessions;
    }
    public void setSessions(List<SessionEntity> sessions) {
        this.sessions = sessions;
    }
    public Double getSessionFee() {
        return sessionFee;
    }
    public void setSessionFee(Double sessionFee) {
        this.sessionFee = sessionFee;
    }


}
