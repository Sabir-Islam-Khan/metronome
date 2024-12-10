package co.asterisklab.metronome.repositories;


import co.asterisklab.metronome.models.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findByDay(String day);
    List<Routine> findBySection(String section);
    List<Routine> findByCourseCode(String courseCode);
    List<Routine> findByTeacherInitial(String teacherInitial);
}
