package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "name should not be blank")
    private String name;

    @Column(name = "email")
    @Email(message = "email should be valid")
    @NotBlank(message = "email should not be blank")
    private String email;

    @Column(name = "phone")
    @NotBlank(message = "phone should not be blank")
    private String phone;

    @Column(name = "address")
    @NotBlank(message = "address should not be blank")
    private String address;

    @Column(name = "city")
    @NotBlank(message = "city should not be blank")
    private String city;

    @OneToMany(mappedBy = "student")
    private List<SessionEntity> sessions;

    // Default Constructor
    public StudentEntity() {
    }

    // Parameterized Constructor
    public StudentEntity(Integer id, String name, String email, String phone, String address, String city,
            List<SessionEntity> sessions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public List<SessionEntity> getSessions() {
        return sessions;
    }
    public void setSessions(List<SessionEntity> sessions) {
        this.sessions = sessions;
    }


}