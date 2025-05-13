package com.example.demo.mapper;

import com.example.demo.dto.SessionDTO;
import com.example.demo.entity.SessionEntity;

public class SessionDTOMapper {
    public static SessionDTO map(SessionEntity sessionEntity) {
        if (sessionEntity == null) {
            return null;
        }
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setSessionId(sessionEntity.getSessionId());
        sessionDTO.setSessionName(sessionEntity.getSessionName());
        sessionDTO.setStartDate(sessionEntity.getStartDate());
        sessionDTO.setEndDate(sessionEntity.getEndDate());
        return sessionDTO;
    }

    public static SessionEntity map(SessionDTO sessionDTO) {
        if (sessionDTO == null) {
            return null;
        }
        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setSessionId(sessionDTO.getSessionId());
        sessionEntity.setSessionName(sessionDTO.getSessionName());
        sessionEntity.setStartDate(sessionDTO.getStartDate());
        sessionEntity.setEndDate(sessionDTO.getEndDate());
        return sessionEntity;
    }

    
}
