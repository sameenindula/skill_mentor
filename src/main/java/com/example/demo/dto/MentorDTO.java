package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentorDTO {
    Integer mentorId;
    String firstName;
    String lastName;
    String address;
    String email;
    String title;
    String profession;
    String subject;
    String qualification;
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



}
