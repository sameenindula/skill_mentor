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



    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudent(@RequestParam(required = false) String name){
        List<StudentDTO> allStudents=studentService.getStudent(name);
        return new ResponseEntity<>(allStudents,HttpStatus.OK);
    }




    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
        return new ResponseEntity<>(studentDTO,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id){
        StudentDTO studentDTO = studentService.findById(id);
        return new ResponseEntity<>(studentDTO,HttpStatus.OK);
    }
    
    // @PutMapping("/{id}")
    // public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO) {
    //     StudentDTO studentDTOs= studentService.updateStudent(id,studentDTO);
    //     return new ResponseEntity<>(studentDTOs,HttpStatus.OK);
    // }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable Integer id){
        StudentDTO studentDTOs=studentService.deleteStudent(id);
        return new ResponseEntity<>(studentDTOs,HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO ){
        StudentDTO studentDTOs=studentService.updateStudent(id, studentDTO);
        return new ResponseEntity<>(studentDTOs,HttpStatus.OK);
    }
    
}
