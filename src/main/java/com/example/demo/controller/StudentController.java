package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;




@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;




    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO studentDTOs =studentService.createStudent(studentDTO);
        return new ResponseEntity<>(studentDTOs,HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getStudent(@RequestParam(required = false) List<String> address){
        List<StudentDTO> students = studentService.getStudent(address);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <StudentDTO> findById(@PathVariable Integer id){
        StudentDTO students = studentService.findById(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    @PutMapping()
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO studentDTOs= studentService.updateStudent(studentDTO);
        return new ResponseEntity<>(studentDTOs,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable Integer id){
        StudentDTO studentDTOs=studentService.deleteStudent(id);
        return new ResponseEntity<>(studentDTOs,HttpStatus.OK);
    }
    
    // @PutMapping("{id}")
    // public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO ){
    //     StudentDTO studentDTOs=studentService.updateStudent(id, studentDTO);
    //     return new ResponseEntity<>(studentDTOs,HttpStatus.OK);
    // }
    
}
