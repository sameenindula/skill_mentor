package com.example.demo.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.mapper.StudentDTOMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;




    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        final StudentEntity studentEntity=StudentDTOMapper.map(studentDTO);
        final StudentEntity savedEntity= studentRepository.save(studentEntity);
        return StudentDTOMapper.map(savedEntity);
    
}

    @Override
    public List<StudentDTO> getStudent(List<String> address) {
            final List<StudentEntity> studentEntities=studentRepository.findAll();
            return studentEntities
            .stream()
            .filter(student-> address==null || address.contains(student.getAddress()))
            .map(StudentDTOMapper::map)
            .toList();
            }

    

    @Override
    public StudentDTO findById(Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        return StudentDTOMapper.map(studentEntity);
    }


    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = studentRepository.findById(studentDTO.getId()).orElse(null);
        if (studentEntity!=null) {
            studentEntity.setName(studentDTO.getName());
            studentEntity.setAddress(studentDTO.getAddress());
            studentEntity.setEmail(studentDTO.getEmail());
            studentEntity.setPhone(studentDTO.getPhone());
            studentEntity.setCity(studentDTO.getCity());
            StudentEntity savedEntity = studentRepository.save(studentEntity);
            return StudentDTOMapper.map(savedEntity);
            
        }else{
            return null;
        }
        
    }


    @Override
    public StudentDTO deleteStudent(Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        StudentDTO studentDTOs= StudentDTOMapper.map(studentEntity);
        studentRepository.deleteById(id);
        return studentDTOs;
    }
}

