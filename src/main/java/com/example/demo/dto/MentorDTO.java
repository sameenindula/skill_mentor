package com.example.demo.dto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
    ClassRoomDTO classroom;
    
    public MentorDTO(Integer mentorId, String firstName, String lastName, String address, String email, String title,
    String profession, String subject, String qualification, ClassRoomDTO classroom) {
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
    }

    public MentorDTO() {
        //TODO Auto-generated constructor stub
    }



}
