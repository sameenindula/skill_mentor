package com.example.demo.mapper;

import com.example.demo.dto.SessionDTO;
import com.example.demo.entity.ClassRoomEntity;
import com.example.demo.entity.MentorEntity;
import com.example.demo.entity.SessionEntity;
import com.example.demo.entity.StudentEntity;

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
        sessionDTO.setMentor(MentorDTOMapper.map(sessionEntity.getMentor()));
        sessionDTO.setStudent(StudentDTOMapper.map(sessionEntity.getStudent()));
        sessionDTO.setClassRoom(ClassRoomDTOMapper.map(sessionEntity.getClassroom()));
        return sessionDTO;
    }

    public static SessionEntity map(SessionDTO sessionDTO, MentorEntity mentorEntity, StudentEntity studentEntity, ClassRoomEntity classRoomEntity) {
        
        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setSessionId(sessionDTO.getSessionId());
        sessionEntity.setSessionName(sessionDTO.getSessionName());
        sessionEntity.setStartDate(sessionDTO.getStartDate());
        sessionEntity.setEndDate(sessionDTO.getEndDate());
        sessionEntity.setMentor(MentorDTOMapper.map(sessionDTO.getMentor()));
        sessionEntity.setStudent(StudentDTOMapper.map(sessionDTO.getStudent()));
        sessionEntity.setClassroom(ClassRoomDTOMapper.map(sessionDTO.getClassRoom()));
        return sessionEntity;
     
    }

}


