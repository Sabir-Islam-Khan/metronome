package co.asterisklab.metronome.controllers;

import co.asterisklab.metronome.dtos.RoutineDTO;
import co.asterisklab.metronome.services.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/routines")
public class RoutineController {

    @Autowired
    private RoutineService routineService;

    // Create a new routine
    @PostMapping
    public ResponseEntity<RoutineDTO> createRoutine(@RequestBody RoutineDTO routineDTO) {
        RoutineDTO createdRoutine = routineService.createRoutine(routineDTO);
        return new ResponseEntity<>(createdRoutine, HttpStatus.CREATED);
    }

    // Get all routines
    @GetMapping
    public ResponseEntity<List<RoutineDTO>> getAllRoutines() {
        List<RoutineDTO> routines = routineService.getAllRoutines();
        return new ResponseEntity<>(routines, HttpStatus.OK);
    }

    // Get routine by ID
    @GetMapping("/{id}")
    public ResponseEntity<RoutineDTO> getRoutineById(@PathVariable Long id) {
        RoutineDTO routine = routineService.getRoutineById(id);
        if (routine != null) {
            return new ResponseEntity<>(routine, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a routine
    @PutMapping("/{id}")
    public ResponseEntity<RoutineDTO> updateRoutine(
            @PathVariable Long id,
            @RequestBody RoutineDTO routineDTO) {
        RoutineDTO updatedRoutine = routineService.updateRoutine(id, routineDTO);
        if (updatedRoutine != null) {
            return new ResponseEntity<>(updatedRoutine, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a routine
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoutine(@PathVariable Long id) {
        boolean deleted = routineService.deleteRoutine(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get routines by day
    @GetMapping("/day/{dayId}")
    public ResponseEntity<List<RoutineDTO>> getRoutinesByDayId(@PathVariable String dayId) {
        List<RoutineDTO> routines = routineService.getRoutinesByDayId(dayId);
        return new ResponseEntity<>(routines, HttpStatus.OK);
    }

    // Get routines by section
    @GetMapping("/section/{section}")
    public ResponseEntity<List<RoutineDTO>> getRoutinesBySection(@PathVariable String section) {
        List<RoutineDTO> routines = routineService.getRoutinesBySection(section);
        return new ResponseEntity<>(routines, HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherInitial}")
    public ResponseEntity<List<RoutineDTO>> getRoutinesByTeacherInitial(@PathVariable String teacherInitial) {
        List<RoutineDTO> routines = routineService.getRoutinesByTeacherInitial(teacherInitial);
        return new ResponseEntity<>(routines, HttpStatus.OK);
    }

    // Get routines by employee ID
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<RoutineDTO>> getRoutinesByEmployeeId(@PathVariable String employeeId) {
        List<RoutineDTO> routines = routineService.getRoutinesByEmployeeId(employeeId);
        return new ResponseEntity<>(routines, HttpStatus.OK);
    }


}