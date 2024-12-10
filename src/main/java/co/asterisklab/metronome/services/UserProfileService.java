package co.asterisklab.metronome.services;

import co.asterisklab.metronome.dtos.UserProfileDTO;
import co.asterisklab.metronome.models.UserProfile;
import co.asterisklab.metronome.repositories.UserProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    // Create
    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileDTO, userProfile);
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);

        UserProfileDTO savedDTO = new UserProfileDTO();
        BeanUtils.copyProperties(savedUserProfile, savedDTO);
        return savedDTO;
    }

    // Read All
    public List<UserProfileDTO> getAllUserProfiles() {
        return userProfileRepository.findAll().stream()
                .map(userProfile -> {
                    UserProfileDTO dto = new UserProfileDTO();
                    BeanUtils.copyProperties(userProfile, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Read by ID
    public UserProfileDTO getUserProfileById(Long id) {
        Optional<UserProfile> userProfile = userProfileRepository.findById(id);
        if (userProfile.isPresent()) {
            UserProfileDTO dto = new UserProfileDTO();
            BeanUtils.copyProperties(userProfile.get(), dto);
            return dto;
        }
        return null;
    }

    // Update
    public UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO) {
        Optional<UserProfile> existingUserProfile = userProfileRepository.findById(id);
        if (existingUserProfile.isPresent()) {
            UserProfile userProfile = existingUserProfile.get();
            BeanUtils.copyProperties(userProfileDTO, userProfile, "id");
            UserProfile updatedUserProfile = userProfileRepository.save(userProfile);

            UserProfileDTO updatedDTO = new UserProfileDTO();
            BeanUtils.copyProperties(updatedUserProfile, updatedDTO);
            return updatedDTO;
        }
        return null;
    }

    // Delete
    public boolean deleteUserProfile(Long id) {
        if (userProfileRepository.existsById(id)) {
            userProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Additional custom methods
    public List<UserProfileDTO> getUserProfilesByFirstName(String firstName) {
        return userProfileRepository.findByFirstName(firstName).stream()
                .map(userProfile -> {
                    UserProfileDTO dto = new UserProfileDTO();
                    BeanUtils.copyProperties(userProfile, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public UserProfileDTO getUserProfileByEmployeeId(String employeeId) {
        UserProfile userProfile = userProfileRepository.findByEmployeeId(employeeId);
        if (userProfile != null) {
            UserProfileDTO dto = new UserProfileDTO();
            BeanUtils.copyProperties(userProfile, dto);
            return dto;
        }
        return null;
    }

    // Additional methods for other search criteria
    public List<UserProfileDTO> getUserProfilesByLastName(String lastName) {
        return userProfileRepository.findByLastName(lastName).stream()
                .map(userProfile -> {
                    UserProfileDTO dto = new UserProfileDTO();
                    BeanUtils.copyProperties(userProfile, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<UserProfileDTO> getUserProfilesByInitial(String initial) {
        return userProfileRepository.findByInitial(initial).stream()
                .map(userProfile -> {
                    UserProfileDTO dto = new UserProfileDTO();
                    BeanUtils.copyProperties(userProfile, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}