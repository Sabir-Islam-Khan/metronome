package co.asterisklab.metronome.dtos;

import lombok.Data;

@Data
public class UserProfileDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String initial;
    private String employeeId;
}