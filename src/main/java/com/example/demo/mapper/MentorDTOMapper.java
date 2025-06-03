package com.example.demo.mapper;

import com.example.demo.dto.MentorDTO;
import com.example.demo.entity.MentorEntity;

public class MentorDTOMapper {
    public static MentorDTO map(MentorEntity mentorEntity) {
        if (mentorEntity == null) {
            return null;
        }
        MentorDTO mentorDTO = new MentorDTO();
        mentorDTO.setMentorId(mentorEntity.getMentorId());
        mentorDTO.setFirstName(mentorEntity.getFirstName());
        mentorDTO.setLastName(mentorEntity.getLastName());
        mentorDTO.setSessionFee(mentorEntity.getSessionFee());
        mentorDTO.setAddress(mentorEntity.getAddress());
        mentorDTO.setEmail(mentorEntity.getEmail());
        mentorDTO.setTitle(mentorEntity.getTitle());
        mentorDTO.setProfession(mentorEntity.getProfession());
        mentorDTO.setSubject(mentorEntity.getSubject());
        mentorDTO.setQualification(mentorEntity.getQualification());
        return mentorDTO;
    }

    public static MentorEntity map(MentorDTO mentorDTO) {
        if (mentorDTO == null) {
            return null;
        }
        MentorEntity mentorEntity = new MentorEntity();
        mentorEntity.setMentorId(mentorDTO.getMentorId());
        mentorEntity.setFirstName(mentorDTO.getFirstName());
        mentorEntity.setLastName(mentorDTO.getLastName());
        mentorEntity.setSessionFee(mentorDTO.getSessionFee());
        mentorEntity.setAddress(mentorDTO.getAddress());
        mentorEntity.setEmail(mentorDTO.getEmail());
        mentorEntity.setTitle(mentorDTO.getTitle());
        mentorEntity.setProfession(mentorDTO.getProfession());
        mentorEntity.setSubject(mentorDTO.getSubject());
        mentorEntity.setQualification(mentorDTO.getQualification());
        return mentorEntity;
    }
}
