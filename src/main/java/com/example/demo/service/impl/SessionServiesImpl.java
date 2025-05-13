package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SessionDTO;
import com.example.demo.entity.ClassRoomEntity;
import com.example.demo.entity.MentorEntity;
import com.example.demo.entity.SessionEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.mapper.SessionDTOMapper;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.MentorRepository;
import com.example.demo.repository.SessionRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.SessionService;

@Service

public class SessionServiesImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    // Implement the methods from the SessionService interface here
    @Override
    public SessionDTO createSession(SessionDTO sessionDTO) {
        // Find related entities
        Optional<ClassRoomEntity> classRoomEntityOpt = classRoomRepository.findById(sessionDTO.getClassRoom().getClassRoomId());
        Optional<MentorEntity> mentorEntityOpt = mentorRepository.findById(sessionDTO.getMentor().getMentorId());
        Optional<StudentEntity> studentEntityOpt = studentRepository.findById(sessionDTO.getStudent().getId());

        if (classRoomEntityOpt.isPresent() && mentorEntityOpt.isPresent() && studentEntityOpt.isPresent()) {
            SessionEntity sessionEntity = SessionDTOMapper.map(
                    sessionDTO,mentorEntityOpt.get(),studentEntityOpt.get(),classRoomEntityOpt.get() );
            sessionEntity = sessionRepository.save(sessionEntity);
            return SessionDTOMapper.map(sessionEntity);
        }
        return null;
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
