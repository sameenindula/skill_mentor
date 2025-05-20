package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MentorDTO {
    Integer mentorId;
    @NotBlank(message = "First name is mandatory")
    String firstName;

    @NotBlank(message = "Last name is mandatory")
    String lastName;

    @NotBlank(message = "Address is mandatory")
    String address;

    @NotBlank(message = "Email is mandatory")
    String email;

    @NotBlank(message = "Title is mandatory")
    String title;

    @NotBlank(message = "Profession is mandatory")
    String profession;
    
    @NotBlank(message = "Subject is mandatory")
    String subject;

    @NotBlank(message = "Qualification is mandatory")
    String qualification;

    @NotBlank(message = "Classroom ID is mandatory")
    Integer classRoomId;
    
    public MentorDTO(Integer mentorId, String firstName, String lastName, String address, String email, String title,
    String profession, String subject, String qualification, Integer classRoomId) {
    this.mentorId = mentorId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.title = title;
    this.profession = profession;
    this.subject = subject;
    this.qualification = qualification;
    this.classRoomId = classRoomId;
    }

    public MentorDTO() {
        //TODO Auto-generated constructor stub
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getProfession() {
        return profession;
    }

    public String getSubject() {
        return subject;
    }

    public String getQualification() {
        return qualification;
    }

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }
    



}
