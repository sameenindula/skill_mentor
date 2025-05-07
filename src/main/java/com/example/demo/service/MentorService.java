package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MentorDTO;
@Service
public interface MentorService {
    MentorDTO createMentor(MentorDTO mentorDTO);
    List<MentorDTO> getMentors(List<String> address);
    MentorDTO findById(Integer id);
    MentorDTO updateMentor(MentorDTO mentorDTO);
    MentorDTO deleteMentor(Integer id);
}
