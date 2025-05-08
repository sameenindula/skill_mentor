package com.example.demo.mapper;

import com.example.demo.dto.ClassRoomDTO;
import com.example.demo.entity.ClassRoomEntity;

public class ClassRoomDTOMapper {
    public static ClassRoomDTO map(ClassRoomEntity classRoomEntity){
        if (classRoomEntity!=null) {
            ClassRoomDTO classRoomDTO=new ClassRoomDTO();
            classRoomDTO.setClassRoomId(classRoomEntity.getClassRoomId());
            classRoomDTO.setTitle(classRoomEntity.getTitle());
            classRoomDTO.setSessionFee(classRoomEntity.getSessionFee());
            classRoomDTO.setEnrollStudentCount(classRoomEntity.getEnrollStudentCount());
            return classRoomDTO;
        }
        return null;
    }



    public static ClassRoomEntity map(ClassRoomDTO classRoomDTO){
        if (classRoomDTO!=null) {
            ClassRoomEntity classRoomEntity=new ClassRoomEntity();
            classRoomEntity.setClassRoomId(classRoomDTO.getClassRoomId());
            classRoomEntity.setTitle(classRoomDTO.getTitle());
            classRoomEntity.setSessionFee(classRoomDTO.getSessionFee());
            classRoomEntity.setEnrollStudentCount(classRoomDTO.getEnrollStudentCount());
            return classRoomEntity;
        }
        return null;
    }
}
