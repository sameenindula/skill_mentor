package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClassRoomDTO;
@Service
public interface ClassRoomService {
    ClassRoomDTO createClass(ClassRoomDTO classRoomDTO);
    List<ClassRoomDTO> getAllClass();
    ClassRoomDTO updateClass(ClassRoomDTO classRoomDTO);
    ClassRoomDTO deleteClass(Integer id);
    ClassRoomDTO findById(Integer id);
}
