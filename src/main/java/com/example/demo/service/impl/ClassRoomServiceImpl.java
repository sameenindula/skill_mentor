package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ClassRoomDTO;
import com.example.demo.entity.ClassRoomEntity;
import com.example.demo.mapper.ClassRoomDTOMapper;
import com.example.demo.mapper.MentorDTOMapper;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.service.ClassRoomService;
@Service
public class ClassRoomServiceImpl implements ClassRoomService{
    @Autowired
    ClassRoomRepository classRoomRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    // @CacheEvict(value = "classRoomCache", key = "#classRoomDTO.classRoomId")
    public ClassRoomDTO createClass(ClassRoomDTO classRoomDTO) {
        ClassRoomEntity classRoomEntity = ClassRoomDTOMapper.map(classRoomDTO);
        ClassRoomEntity saveClassRoom=classRoomRepository.save(classRoomEntity);
        return ClassRoomDTOMapper.map(saveClassRoom);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    // @Cacheable(value = "classRoomCache", key = "#id")
    public List<ClassRoomDTO> getAllClass() {
        List<ClassRoomEntity> classRoomEntity=classRoomRepository.findAll();
        List<ClassRoomDTO> classRoomDTOs=classRoomEntity
        .stream()
        .map(entity->{
            ClassRoomDTO classRoomDTO=ClassRoomDTOMapper.map(entity);
            if(!Objects.isNull(entity.getMentor())){
                classRoomDTO.setMentor(MentorDTOMapper.map(entity.getMentor()));
            }
            return classRoomDTO;
        }).
        toList();
        return classRoomDTOs;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    // @CacheEvict(value = "classRoomCache", key = "#classRoomDTO.classRoomId")
    public ClassRoomDTO updateClass(ClassRoomDTO classRoomDTO) {

        ClassRoomEntity classRoomEntity2=classRoomRepository.findById(classRoomDTO.getClassRoomId()).orElse(null);
        if (classRoomEntity2!=null) {
            classRoomEntity2.setClassRoomId(classRoomDTO.getClassRoomId());
        classRoomEntity2.setEnrollStudentCount(classRoomDTO.getEnrollStudentCount());
        classRoomEntity2.setTitle(classRoomDTO.getTitle());
        ClassRoomEntity classRoomEntity3=classRoomRepository.save(classRoomEntity2);
        return ClassRoomDTOMapper.map(classRoomEntity3);
        }
        return null;
        
        
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    // @CacheEvict(value = "classRoomCache", key = "#id")
    public ClassRoomDTO deleteClass(Integer id) {
        ClassRoomEntity classRoomEntity2=classRoomRepository.findById(id).orElse(null);
        ClassRoomDTO classRoomDTO=ClassRoomDTOMapper.map(classRoomEntity2);
        classRoomRepository.delete(classRoomEntity2);
        return classRoomDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    // @Cacheable(value = "classRoomCache", key = "#id")
    public ClassRoomDTO findById(Integer id) {
        ClassRoomEntity classRoomEntity2=classRoomRepository.findById(id).orElse(null);
        return ClassRoomDTOMapper.map(classRoomEntity2);
        
    }
    
}
