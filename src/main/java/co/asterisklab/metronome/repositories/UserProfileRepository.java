package co.asterisklab.metronome.repositories;

import co.asterisklab.metronome.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    List<UserProfile> findByFirstName(String firstName);
    UserProfile findByEmployeeId(String employeeId);
    List<UserProfile> findByLastName(String lastName);
    List<UserProfile> findByInitial(String initial);
}