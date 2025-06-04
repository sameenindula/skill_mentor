package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Constants;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/acadamic")
@Validated
public class StudentController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;




    @PostMapping(value="/student", produces=Constants.APPLICATION_JSON,consumes=Constants.APPLICATION_JSON)
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO studentDTO) {
        log.info("Creating student with details: {}", studentDTO);
        StudentDTO studentDTOs =studentService.createStudent(studentDTO);
        return new ResponseEntity<>(studentDTOs,HttpStatus.OK);

    }

    @GetMapping(value="/student", consumes=Constants.APPLICATION_JSON)
    public ResponseEntity<List<StudentDTO>> getStudent(@RequestParam(required = false) List<String> address){
        List<StudentDTO> students = studentService.getStudent(address);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value="/student/{id}", consumes=Constants.APPLICATION_JSON)
    public ResponseEntity <StudentDTO> findById(@PathVariable Integer id){
        StudentDTO students = studentService.findById(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    @PutMapping(value="/student",produces=Constants.APPLICATION_JSON, consumes=Constants.APPLICATION_JSON)
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO studentDTOs= studentService.updateStudent(studentDTO);
        return new ResponseEntity<>(studentDTOs,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/student/{id}",consumes=Constants.APPLICATION_JSON)
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
