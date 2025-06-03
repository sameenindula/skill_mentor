package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuditDTO;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.service.SessionService;

@RestController
@RequestMapping("/audit")
public class AdditController {

    @Autowired
    private SessionService sessionService;

    public ResponseEntity<List<AuditDTO>> getAllAudits(){
            List<AuditDTO> auditDTOS = sessionService.getAllAudits();
            return new ResponseEntity<>(auditDTOS, HttpStatus.OK);
        }
    @GetMapping("/mentor-payments")
    public ResponseEntity<List<PaymentDTO>> findMentorPayments(@RequestParam(name = "startDate", required = false) String startDate,
                                                               @RequestParam(name = "endDate", required = false) String endDate){
        List<PaymentDTO> auditDTOS = sessionService.findMentorPayments(startDate, endDate);
        return new ResponseEntity<>(auditDTOS, HttpStatus.OK);
    }
    

    }
