package co.asterisklab.metronome.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Entity
@Table(name = "routines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key")
    private Long key;

    @Column(name = "room_id", nullable = false)
    private String roomId;

    @Column(name = "teacher_initial")
    private String teacherInitial;

    @Column(name = "section", nullable = false)
    private String section;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "day_id", nullable = false)
    private String dayId;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "dept", nullable = false)
    private String dept;
}