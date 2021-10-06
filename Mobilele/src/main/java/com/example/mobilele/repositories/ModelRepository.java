package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
