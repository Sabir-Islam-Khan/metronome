package co.asterisklab.metronome.services;

import co.asterisklab.metronome.dtos.RoutineDTO;
import co.asterisklab.metronome.models.Routine;
import co.asterisklab.metronome.repositories.RoutineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    // Create
    public RoutineDTO createRoutine(RoutineDTO routineDTO) {
        Routine routine = new Routine();
        BeanUtils.copyProperties(routineDTO, routine);
        Routine savedRoutine = routineRepository.save(routine);

        RoutineDTO savedDTO = new RoutineDTO();
        BeanUtils.copyProperties(savedRoutine, savedDTO);
        return savedDTO;
    }

    // Read All
    public List<RoutineDTO> getAllRoutines() {
        return routineRepository.findAll().stream()
                .map(routine -> {
                    RoutineDTO dto = new RoutineDTO();
                    BeanUtils.copyProperties(routine, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Read by ID
    public RoutineDTO getRoutineById(Long id) {
        Optional<Routine> routine = routineRepository.findById(id);
        if (routine.isPresent()) {
            RoutineDTO dto = new RoutineDTO();
            BeanUtils.copyProperties(routine.get(), dto);
            return dto;
        }
        return null;
    }

    // Update
    public RoutineDTO updateRoutine(Long id, RoutineDTO routineDTO) {
        Optional<Routine> existingRoutine = routineRepository.findById(id);
        if (existingRoutine.isPresent()) {
            Routine routine = existingRoutine.get();
            BeanUtils.copyProperties(routineDTO, routine, "id");
            Routine updatedRoutine = routineRepository.save(routine);

            RoutineDTO updatedDTO = new RoutineDTO();
            BeanUtils.copyProperties(updatedRoutine, updatedDTO);
            return updatedDTO;
        }
        return null;
    }

    // Delete
    public boolean deleteRoutine(Long id) {
        if (routineRepository.existsById(id)) {
            routineRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Additional custom methods
    public List<RoutineDTO> getRoutinesByDayId(String dayId) {
        return routineRepository.findByDayId(dayId).stream()
                .map(routine -> {
                    RoutineDTO dto = new RoutineDTO();
                    BeanUtils.copyProperties(routine, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<RoutineDTO> getRoutinesBySection(String section) {
        return routineRepository.findBySection(section).stream()
                .map(routine -> {
                    RoutineDTO dto = new RoutineDTO();
                    BeanUtils.copyProperties(routine, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Get routines by teacher initial
    public List<RoutineDTO> getRoutinesByTeacherInitial(String teacherInitial) {
        return routineRepository.findByTeacherInitial(teacherInitial).stream()
                .map(routine -> {
                    RoutineDTO dto = new RoutineDTO();
                    BeanUtils.copyProperties(routine, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Get routines by employee ID
    public List<RoutineDTO> getRoutinesByEmployeeId(String employeeId) {
        return routineRepository.findByEmployeeId(employeeId).stream()
                .map(routine -> {
                    RoutineDTO dto = new RoutineDTO();
                    BeanUtils.copyProperties(routine, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

}