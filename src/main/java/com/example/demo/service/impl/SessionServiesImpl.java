package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SessionDTO;
import com.example.demo.entity.SessionEntity;
import com.example.demo.mapper.SessionDTOMapper;
import com.example.demo.repository.SessionRepository;
import com.example.demo.service.SessionService;

@Service

public class SessionServiesImpl implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    // Implement the methods from the SessionService interface here
    @Override
    public SessionDTO createSession(SessionDTO sessionDTO) {
        SessionEntity sessionEntity = SessionDTOMapper.map(sessionDTO);
        sessionEntity = sessionRepository.save(sessionEntity);
        return SessionDTOMapper.map(sessionEntity);
    }

    @Override
    public List<SessionDTO> getSessions() {
        List<SessionEntity> sessionEntities = sessionRepository.findAll();
        return sessionEntities.stream()
                .map(entity -> SessionDTOMapper.map(entity)).toList();
    }

    @Override
    public SessionDTO findById(Integer id) {
        SessionEntity sessionEntity = sessionRepository.findById(id).orElse(null);
        return SessionDTOMapper.map(sessionEntity);
    }

    @Override
    public SessionDTO updateSession(SessionDTO sessionDTO) {
        SessionEntity sessionEntity = sessionRepository.findById(sessionDTO.getSessionId()).orElse(null);
        if (sessionEntity != null) {
            sessionEntity.setSessionName(sessionDTO.getSessionName());
            sessionEntity.setStartDate(sessionDTO.getStartDate());
            sessionEntity.setEndDate(sessionDTO.getEndDate());
            sessionEntity = sessionRepository.save(sessionEntity);
            return SessionDTOMapper.map(sessionEntity);
        } else {
            return null;
        }
    }

    @Override
    public SessionDTO deleteSession(Integer id) {
        SessionEntity sessionEntity = sessionRepository.findById(id).orElse(null);
        if (sessionEntity != null) {
            sessionRepository.delete(sessionEntity);
            return SessionDTOMapper.map(sessionEntity);
        } else {
            return null;
        }
    }
    
}
