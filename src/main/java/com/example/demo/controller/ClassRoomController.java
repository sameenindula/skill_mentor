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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClassRoomDTO;
import com.example.demo.service.ClassRoomService;
import com.example.demo.common.Constants;


import jakarta.validation.Valid;

@Validated

@RestController
@RequestMapping("/academic")
public class ClassRoomController {

    @Autowired
    ClassRoomService classRoomService;

    @GetMapping(value="/classRoom" ,produces=Constants.APPLICATION_JSON)
    public ResponseEntity<List<ClassRoomDTO>> getAllClass() {
        List<ClassRoomDTO> classRooms = classRoomService.getAllClass();
        return ResponseEntity.ok(classRooms);
    }

    @GetMapping(value="/classroom/{id}", produces=Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> findById(@PathVariable Integer id) {
        ClassRoomDTO classRoom = classRoomService.findById(id);
        return ResponseEntity.ok(classRoom);
    }

    @PostMapping(value="/classroom",consumes=Constants.APPLICATION_JSON,produces=Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> createClass(@Valid @RequestBody  ClassRoomDTO classRoomDTO) {
        final ClassRoomDTO createdClass = classRoomService.createClass(classRoomDTO);
        return ResponseEntity.ok(createdClass);
    }

    @PutMapping(value="/classroom", consumes=Constants.APPLICATION_JSON, produces=Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> updateClass(@RequestBody ClassRoomDTO classRoomDTO) {
        ClassRoomDTO updatedClass = classRoomService.updateClass(classRoomDTO);
        return new ResponseEntity<>(updatedClass, HttpStatus.OK);
    }

    @DeleteMapping(value= "/classRoom/{id}, produces=Constants.APPLICATION_JSON)")
    public ResponseEntity<ClassRoomDTO> deleteClass(@PathVariable Integer id) {
        ClassRoomDTO deletedClass = classRoomService.deleteClass(id);
        return new ResponseEntity<>(deletedClass, HttpStatus.OK);
    }
}
