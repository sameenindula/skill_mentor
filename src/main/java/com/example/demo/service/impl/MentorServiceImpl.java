package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MentorDTO;
import com.example.demo.entity.MentorEntity;
import com.example.demo.mapper.MentorDTOMapper;
import com.example.demo.repository.MentorRepository;
import com.example.demo.service.MentorService;

@Service
public class MentorServiceImpl implements MentorService {
    
    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = MentorDTOMapper.map(mentorDTO);
        MentorEntity savedEntity = mentorRepository.save(mentorEntity);
        return MentorDTOMapper.map(savedEntity);
    }

    @Override
    public List<MentorDTO> getMentors(List<String> address) {
        List<MentorEntity> mentorEntities = mentorRepository.findAll();
        return mentorEntities.stream()
            .filter(mentor -> address == null || address.contains(mentor.getAddress()))
            .map(MentorDTOMapper::map)
            .toList();
    }

    @Override
    public MentorDTO findById(Integer id) {
        MentorEntity mentorEntity = mentorRepository.findById(id).orElse(null);
        return MentorDTOMapper.map(mentorEntity);
    }

    @Override
    public MentorDTO updateMentor(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = mentorRepository.findById(mentorDTO.getMentorId()).orElse(null);
        if (mentorEntity != null) {
            mentorEntity.setFirstName(mentorDTO.getFirstName());
            mentorEntity.setLastName(mentorDTO.getLastName());
            mentorEntity.setAddress(mentorDTO.getAddress());
            mentorEntity.setEmail(mentorDTO.getEmail());
            mentorEntity.setTitle(mentorDTO.getTitle());
            mentorEntity.setProfession(mentorDTO.getProfession());
            mentorEntity.setSubject(mentorDTO.getSubject());
            mentorEntity.setQualification(mentorDTO.getQualification());
            MentorEntity savedEntity = mentorRepository.save(mentorEntity);
            return MentorDTOMapper.map(savedEntity);
        }
        return null;
    }

    @Override
    public MentorDTO deleteMentor(Integer id) {
        MentorEntity mentorEntity = mentorRepository.findById(id).orElse(null);
        MentorDTO mentorDTO = MentorDTOMapper.map(mentorEntity);
        if (mentorEntity != null) {
            mentorRepository.deleteById(id);
        }
        return mentorDTO;
    }
}
