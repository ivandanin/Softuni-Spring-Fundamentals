package com.example.exam.repos;

import com.example.exam.models.entityModels.Ship;
import com.example.exam.models.viewModels.ShipViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query("SELECT s FROM Ship AS s ORDER BY s.health DESC")
    List<Ship> findAllShipsOrderByHealthDesc();

    @Query("SELECT id, health, power FROM Ship ORDER BY id, health, power")
    List<Ship> findAllShips();
}
