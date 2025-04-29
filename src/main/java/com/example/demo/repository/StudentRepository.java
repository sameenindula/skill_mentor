package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.StudentDTO;
@Repository
public class StudentRepository {
    private List<StudentDTO> students=new ArrayList<>();

    public StudentDTO createStudent(StudentDTO studentDTO){
        students.add(studentDTO);
        return studentDTO;
    }

    public List<StudentDTO> getStudent(String name){
        List<StudentDTO> newStudent=students.stream().filter( stu->name==null||stu.getName().equals(name)).toList();
        return newStudent;
    }

    public StudentDTO findById(Integer id){
        Optional<StudentDTO> studentOptional= students.stream().filter(stu ->stu.getId()==id).findFirst();
        return studentOptional.orElse(null);
    }

    // public StudentDTO updateStudent(Integer id,StudentDTO studentDTO){
    //     Optional<StudentDTO> studentDTOOptional = students.stream().filter(stu-> stu.getId()==id).findFirst();
    //     StudentDTO studentDTOs=studentDTOOptional.orElse(null);
    //     int studentIndex=students.indexOf(studentDTOs);
    //     students.set(studentIndex, studentDTO);
    //     return studentDTOs;
        
    // }

    public StudentDTO deleteStudent(Integer id){
        Optional<StudentDTO> studentDTOOptional = students.stream().filter(stu-> stu.getId()==id).findFirst();
        StudentDTO studentDTOs=studentDTOOptional.orElse(null);
        int studentIndex=students.indexOf(studentDTOs);
        students.remove(studentIndex);
        return studentDTOs; 
    }
    public StudentDTO  updateStudent(Integer id,StudentDTO studentDTO){
        Optional<StudentDTO> studentOptional=students.stream().filter((stu)->stu.getId()==id).findFirst();
        StudentDTO studentDTOs=studentOptional.orElse(studentDTO);
        int studentIndex=students.indexOf(studentDTOs);
        students.set(studentIndex, studentDTO);
        return studentDTO;
    }
}
