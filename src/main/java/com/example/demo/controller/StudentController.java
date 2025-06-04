package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    private StudentService studentService;

    @PostMapping(value = "/student", produces = Constants.APPLICATION_JSON, consumes = Constants.APPLICATION_JSON)
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO studentDTO) {
        log.info("Creating student with details: {}", studentDTO);
        StudentDTO savedStudent = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping(value = "/student", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<List<StudentDTO>> getStudent(@RequestParam(required = false) List<String> address) {
        List<StudentDTO> students = studentService.getStudent(address);
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/student/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) {
        StudentDTO student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping(value = "/student", produces = Constants.APPLICATION_JSON, consumes = Constants.APPLICATION_JSON)
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody @Valid StudentDTO studentDTO) {
        StudentDTO updatedStudent = studentService.updateStudent(studentDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping(value = "/student/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable Integer id) {
        StudentDTO deletedStudent = studentService.deleteStudent(id);
        return ResponseEntity.ok(deletedStudent);
    }

}
