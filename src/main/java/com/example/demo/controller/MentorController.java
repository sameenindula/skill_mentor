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
import com.example.demo.dto.MentorDTO;
import com.example.demo.exception.MentorException;
import com.example.demo.service.MentorService;

import jakarta.validation.Valid;


@Validated
@RestController
@RequestMapping("/academic")
public class MentorController {
    @Autowired
    MentorService mentorService;

    @PostMapping(value = "/mentor", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
public ResponseEntity<MentorDTO> createMentor(@RequestBody @Valid MentorDTO mentorDTO) throws MentorException {
    MentorDTO savedDTO = mentorService.createMentor(mentorDTO);
    return ResponseEntity.ok(savedDTO);
}


    @GetMapping(value = "/mentor", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<?> getAllMentors(@RequestParam(required = false) List<String> address) throws MentorException {
    return new ResponseEntity<>(mentorService.getMentors(address), HttpStatus.OK);
}

    

    @GetMapping(value = "/mentor/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<MentorDTO> getMentor(@PathVariable Integer id) throws MentorException {
        return new ResponseEntity<>(mentorService.findById(id),HttpStatus.OK);
    }

    @PutMapping(value="/mentor", consumes=Constants.APPLICATION_JSON, produces=Constants.APPLICATION_JSON)
    public ResponseEntity<MentorDTO> updateMentor(@RequestBody MentorDTO mentorDTO)throws MentorException {
        return new ResponseEntity<>(mentorService.updateMentor(mentorDTO),HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/mentor/{id}", produces=Constants.APPLICATION_JSON)
    public ResponseEntity<MentorDTO> DeleteMentor(@PathVariable Integer id)throws MentorException {
        return new ResponseEntity<>(mentorService.deleteMentor(id),HttpStatus.OK);
    }
}
