package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuditDTO;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.SessionDTO;

@Service
public interface SessionService {
    SessionDTO createSession(SessionDTO sessionDTO);
    List<SessionDTO> getSessions();
    SessionDTO findById(Integer id);
    SessionDTO updateSession(SessionDTO sessionDTO);
    SessionDTO deleteSession(Integer id);

    List<AuditDTO> getAllAudits();
    List<PaymentDTO> findMentorPayments(String startDate, String endDate);
}
