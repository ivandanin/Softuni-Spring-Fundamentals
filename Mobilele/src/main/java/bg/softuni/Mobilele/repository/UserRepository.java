package bg.softuni.Mobilele.repository;

import bg.softuni.Mobilele.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
