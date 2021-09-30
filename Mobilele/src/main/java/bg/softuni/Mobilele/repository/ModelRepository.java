package bg.softuni.Mobilele.repository;

import bg.softuni.Mobilele.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
