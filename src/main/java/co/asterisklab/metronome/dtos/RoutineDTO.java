package co.asterisklab.metronome.dtos;

import lombok.Data;
import java.time.LocalTime;

@Data
public class RoutineDTO {
    private Long id;
    private String day;
    private String time;
    private String room;
    private String section;
    private String courseCode;
    private String courseName;
    private String teacherInitial;
}