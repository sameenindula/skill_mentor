package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="classroon")
public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classRoomId;

    @Column(name="title")
    private String title;

    @Column(name="session_fee")
    private Double sessionFee;

    @Column(name="enroll_student_count")
    private Integer enrollStudentCount;
    
    
}
