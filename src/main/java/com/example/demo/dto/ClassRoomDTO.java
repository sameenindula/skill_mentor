package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClassRoomDTO {
    Integer classRoomId;
    String title;
    Double sessionFee;
    Integer enrollStudentCount;

    public ClassRoomDTO(){}

    public ClassRoomDTO(Integer classRoomId, String title, Double sessionFee, Integer enrollStudentCount) {
        this.classRoomId = classRoomId;
        this.title = title;
        this.sessionFee = sessionFee;
        this.enrollStudentCount = enrollStudentCount;
    }

}
