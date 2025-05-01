package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.dto.StudentDTO;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDao studentDao;


    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentDTO studentDTOs=studentDao.createStudent(studentDTO);
        return studentDTOs;
    
}


    @Override
    public List<StudentDTO> getStudent() {
        return studentDao.getStudent();
    }


    // @Override
    // public StudentDTO findById(Integer id) {
    //     return studentRepository.findById(id);
    // }


    // @Override
    // public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
    //     return studentRepository.updateStudent(id,studentDTO);
        
    // }


    // @Override
    // public StudentDTO deleteStudent(Integer id) {
    //     return studentRepository.deleteStudent(id);
    // }
}

