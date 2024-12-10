package co.asterisklab.metronome.controllers;

import co.asterisklab.metronome.dtos.UserProfileDTO;
import co.asterisklab.metronome.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-profiles")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    // Create a new user profile
    @PostMapping
    public ResponseEntity<UserProfileDTO> createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        UserProfileDTO createdUserProfile = userProfileService.createUserProfile(userProfileDTO);
        return new ResponseEntity<>(createdUserProfile, HttpStatus.CREATED);
    }

    // Get all user profiles
    @GetMapping
    public ResponseEntity<List<UserProfileDTO>> getAllUserProfiles() {
        List<UserProfileDTO> userProfiles = userProfileService.getAllUserProfiles();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    // Get user profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getUserProfileById(@PathVariable Long id) {
        UserProfileDTO userProfile = userProfileService.getUserProfileById(id);
        if (userProfile != null) {
            return new ResponseEntity<>(userProfile, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a user profile
    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDTO> updateUserProfile(
            @PathVariable Long id,
            @RequestBody UserProfileDTO userProfileDTO
    ) {
        UserProfileDTO updatedUserProfile = userProfileService.updateUserProfile(id, userProfileDTO);
        if (updatedUserProfile != null) {
            return new ResponseEntity<>(updatedUserProfile, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a user profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
        boolean deleted = userProfileService.deleteUserProfile(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get user profiles by first name
    @GetMapping("/first-name/{firstName}")
    public ResponseEntity<List<UserProfileDTO>> getUserProfilesByFirstName(@PathVariable String firstName) {
        List<UserProfileDTO> userProfiles = userProfileService.getUserProfilesByFirstName(firstName);
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    // Get user profile by employee ID
    @GetMapping("/employee-id/{employeeId}")
    public ResponseEntity<UserProfileDTO> getUserProfileByEmployeeId(@PathVariable String employeeId) {
        UserProfileDTO userProfile = userProfileService.getUserProfileByEmployeeId(employeeId);
        if (userProfile != null) {
            return new ResponseEntity<>(userProfile, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}