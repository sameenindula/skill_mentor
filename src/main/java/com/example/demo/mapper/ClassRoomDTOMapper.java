package com.example.demo.mapper;

import com.example.demo.dto.ClassRoomDTO;
import com.example.demo.entity.ClassRoomEntity;

public class ClassRoomDTOMapper {
    public static ClassRoomDTO map(ClassRoomEntity classroomEntity) {
        if (classroomEntity == null) {
            return null;
        }
        ClassRoomDTO classroomDTO = new ClassRoomDTO();
        classroomDTO.setClassRoomId(classroomEntity.getClassRoomId());
        classroomDTO.setTitle(classroomEntity.getTitle());
       // classroomDTO.setSessionFee(classroomEntity.getSessionFee());
        classroomDTO.setEnrollStudentCount(classroomEntity.getEnrollStudentCount());
        // classroomDTO.setMentor(MentorDTOMapper.map(classroomEntity.getMentor()));
        return classroomDTO;
    }

    public static ClassRoomEntity map(ClassRoomDTO classroomDTO) {
        if (classroomDTO == null) {
            return null;
        }
        ClassRoomEntity classroomEntity = new ClassRoomEntity();
        classroomEntity.setClassRoomId(classroomDTO.getClassRoomId());
        classroomEntity.setTitle(classroomDTO.getTitle());
       // classroomEntity.setSessionFee(classroomDTO.getSessionFee());
        classroomEntity.setEnrollStudentCount(classroomDTO.getEnrollStudentCount());
        //classroomEntity.setMentor(MentorDTOMapper.map(classroomDTO.getMentor()));
        return classroomEntity;
    }
}
