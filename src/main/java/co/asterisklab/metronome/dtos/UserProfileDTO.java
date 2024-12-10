package co.asterisklab.metronome.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class UserProfileDTO {
    // ID is nullable and will be set by the database
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Initial is required")
    private String initial;

    @NotBlank(message = "Employee ID is required")
    private String employeeId;
}