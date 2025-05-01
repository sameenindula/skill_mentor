package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;

    // Default Constructor
    public StudentDTO() {
    }

    // Parameterized Constructor
    public StudentDTO(Integer id, String name, String email, String phone, String address, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }
}