package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.StudentDTO;
import com.example.demo.utill.DatabaseConnection;


@Repository

public class StudentDaoImpl implements StudentDao {
    @Autowired
    DatabaseConnection databaseConnection;
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public List<StudentDTO> getStudent(String name) {
        return null;
    }

    @Override
    public StudentDTO findById(Integer id) {
        return null;
    }

    @Override
    public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO deleteStudent(Integer id) {
        return null;
    }
}
