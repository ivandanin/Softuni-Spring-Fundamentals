package com.example.linkedout.repos;

import com.example.linkedout.models.entityModels.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company, String> {

    @Query("SELECT c.name FROM Company AS c")
    Optional<Company> findByName(String name);
}
