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

import com.example.demo.dto.SessionDTO;
import com.example.demo.service.SessionService;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/session")
@Validated
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping()
    public ResponseEntity<List<SessionDTO>> getAllSession() {
        return new ResponseEntity<>(sessionService.getSessions(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SessionDTO> createSession(@RequestBody @Valid SessionDTO sessionDTO) {

        SessionDTO sessionDTOs = sessionService.createSession(sessionDTO);
        return new ResponseEntity<>(sessionDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionDTO> findById(@PathVariable Integer id) {
        SessionDTO sessionDTOs = sessionService.findById(id);
        return new ResponseEntity<>(sessionDTOs, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<SessionDTO> updateSession(@RequestBody SessionDTO sessionDTO) {
        SessionDTO sessionDTOs = sessionService.updateSession(sessionDTO);
        return  new ResponseEntity<>(sessionDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SessionDTO> deleteSession(@PathVariable Integer id) {
        SessionDTO sessionDTOs = sessionService.deleteSession(id);
        return new ResponseEntity<>(sessionDTOs, HttpStatus.OK);
    }
    
    
    
}
