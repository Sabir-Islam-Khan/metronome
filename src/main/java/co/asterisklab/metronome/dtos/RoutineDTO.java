package co.asterisklab.metronome.dtos;

import lombok.Data;
import java.time.LocalTime;

@Data
public class RoutineDTO {
    private Long key;
    private String roomId;
    private String teacherInitial;
    private String section;
    private String courseCode;
    private String dayId;
    private String startTime;
    private String endTime;
    private String employeeId;
    private String dept;
}