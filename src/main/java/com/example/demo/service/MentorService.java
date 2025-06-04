package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MentorDTO;
import com.example.demo.exception.MentorException;
@Service
public interface MentorService {
    MentorDTO createMentor(MentorDTO mentorDTO) throws MentorException;
    List<MentorDTO> getMentors(List<String> address) throws MentorException;
    MentorDTO findById(Integer id) throws MentorException;
    MentorDTO updateMentor(MentorDTO mentorDTO) throws MentorException;
    MentorDTO deleteMentor(Integer id) throws MentorException;
}
    