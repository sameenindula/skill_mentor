package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
@Service
public interface StudentService {
    /**
     * 
     * @param studentDTO
     * @return
     */
    StudentDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudent(String name);
    StudentDTO findById(Integer id);
    StudentDTO updateStudent(Integer id,StudentDTO studentDTO);
    StudentDTO deleteStudent(Integer id);
}
