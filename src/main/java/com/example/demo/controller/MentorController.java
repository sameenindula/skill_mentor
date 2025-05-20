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

import com.example.demo.dto.MentorDTO;
import com.example.demo.service.MentorService;

import jakarta.validation.Valid;


@Validated

@RestController
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
    MentorService mentorService;

    @PostMapping()
    public ResponseEntity<MentorDTO> CreateMentor(@RequestBody @Valid MentorDTO mentorDTO){
        return new ResponseEntity<>(mentorService.createMentor(mentorDTO),HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<MentorDTO>> getAllMentors(@RequestParam (required=false) List<String> address){
        return new ResponseEntity<>(mentorService.getMentors(address),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> getMentor(@PathVariable Integer id){
        return new ResponseEntity<>(mentorService.findById(id),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<MentorDTO> updateMentor(@RequestBody MentorDTO mentorDTO){
        return new ResponseEntity<>(mentorService.updateMentor(mentorDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MentorDTO> DeleteMentor(@PathVariable Integer id){
        return new ResponseEntity<>(mentorService.deleteMentor(id),HttpStatus.OK);
    }
    
    
    
    
    
}
