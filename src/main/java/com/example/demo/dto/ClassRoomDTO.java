package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClassRoomDTO {
    private Integer classRoomId;
    private String title;
    private Double sessionFee;
    private Integer enrollStudentCount;
    private MentorDTO mentor;
}
