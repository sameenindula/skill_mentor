package com.example.demo.mapper;

import com.example.demo.dto.AuditDTO;
import com.example.demo.entity.SessionEntity;

public class AduitDTOMapper {
    public static AuditDTO map(SessionEntity sessionEntity) {
        if (sessionEntity == null) {
            return null;
        }
        AuditDTO auditDTO = new AuditDTO();
        auditDTO.setSessionId(sessionEntity.getSessionId());
        auditDTO.setStudentId(sessionEntity.getStudent().getId());
        auditDTO.setStudentFirstName(sessionEntity.getStudent().getName());
        auditDTO.setStudentLastName(""); // Add if you have a last name field, otherwise leave empty or remove
        auditDTO.setStudentEmail(sessionEntity.getStudent().getEmail());
        auditDTO.setStudentPhoneNumber(sessionEntity.getStudent().getPhone());
        // Classroom
        auditDTO.setClassTitle(sessionEntity.getClassroom().getTitle());
        // Mentor
        auditDTO.setMentorId(sessionEntity.getMentor().getMentorId());
        auditDTO.setMentorFirstName(sessionEntity.getMentor().getFirstName());
        auditDTO.setMentorLastName(sessionEntity.getMentor().getLastName());
        // Fee
        // Times and topic
        auditDTO.setStartTime(sessionEntity.getStartDate());
        auditDTO.setEndTime(sessionEntity.getEndDate());
        auditDTO.setTopic(sessionEntity.getSessionTopic());
        return auditDTO;
}
}