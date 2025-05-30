package repo;


import models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<UserProfile,Long> {
    UserProfile findByUsername(String username);
}
