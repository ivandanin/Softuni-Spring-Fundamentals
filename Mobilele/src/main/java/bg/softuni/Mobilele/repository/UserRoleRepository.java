package bg.softuni.Mobilele.repository;

import bg.softuni.Mobilele.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
