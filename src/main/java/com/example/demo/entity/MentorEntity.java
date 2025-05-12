package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mentor")
@Getter
@Setter
@NoArgsConstructor
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
}
