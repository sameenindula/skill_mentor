package com.example.demo.mapper;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;

public class StudentDTOMapper {
    public static StudentDTO map(StudentEntity studentEntity) {
        if (studentEntity == null) {
            return null;
        }
        
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setAddress(studentEntity.getAddress());
        studentDTO.setName(studentEntity.getName());
        studentDTO.setEmail(studentEntity.getEmail());
        studentDTO.setPhone(studentEntity.getPhone());
        studentDTO.setCity(studentEntity.getCity());
        return studentDTO;
    }

    public static StudentEntity map(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }
        
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDTO.getId());
        studentEntity.setAddress(studentDTO.getAddress());
        studentEntity.setName(studentDTO.getName());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setPhone(studentDTO.getPhone());
        studentEntity.setCity(studentDTO.getCity());
        return studentEntity;
    }
}
