package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.MentorDTO;
import com.example.demo.entity.ClassRoomEntity;
import com.example.demo.entity.MentorEntity;
import com.example.demo.mapper.MentorDTOMapper;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.MentorRepository;
import com.example.demo.service.MentorService;


@Service
public class MentorServiceImpl implements MentorService {
    private static final Logger log = LoggerFactory.getLogger(MentorServiceImpl.class);
    
    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    @CacheEvict(value = {"mentorCache","allmentorCache"}, allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        log.info("MentorServiceImpl.createMentor() called with MentorDTO: {}", mentorDTO);
        MentorEntity mentorEntity = MentorDTOMapper.map(mentorDTO);
        MentorEntity savedEntity = mentorRepository.save(mentorEntity);
        if (!Objects.isNull(mentorDTO.getClassRoomId())){
            log.error("MentorServiceImpl.createMentor() called with MentorDTO: {}", mentorDTO);
            Optional<ClassRoomEntity> optionalClassRoomEntity = classRoomRepository.findById(mentorDTO.getClassRoomId());
            if (optionalClassRoomEntity.isPresent()){
                ClassRoomEntity classRoomEntity = optionalClassRoomEntity.get();
                classRoomEntity.setMentor(savedEntity);
                classRoomRepository.save(classRoomEntity);
            }
        }
        return MentorDTOMapper.map(savedEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MentorDTO> getMentors(List<String> address) {
        log.info("MentorServiceImpl.getMentors() called with address: {}", address);
        List<MentorEntity> mentorEntities = mentorRepository.findAll();
        return mentorEntities.stream()
            .map(mentorDTOs -> MentorDTOMapper.map(mentorDTOs))
            .toList();
    }

    @Override
    @Cacheable(value = "allmentorCache",key= "'allMentors'")
    @Transactional(rollbackFor = Exception.class)
    public MentorDTO findById(Integer id) {
        MentorEntity mentorEntity = mentorRepository.findById(id).orElse(null);
        return MentorDTOMapper.map(mentorEntity);
    }

    @Override
    @CachePut(value = "mentorCache", key = "#mentorupdate")
    @CacheEvict(value = "allmentorCache", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
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
    @CacheEvict(value = {"mentorCache","allmentorCache"}, allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public MentorDTO deleteMentor(Integer id) {
        MentorEntity mentorEntity = mentorRepository.findById(id).orElse(null);
        MentorDTO mentorDTO = MentorDTOMapper.map(mentorEntity);
        if (mentorEntity != null) {
            mentorRepository.deleteById(id);
        }
        return mentorDTO;
    }
}
