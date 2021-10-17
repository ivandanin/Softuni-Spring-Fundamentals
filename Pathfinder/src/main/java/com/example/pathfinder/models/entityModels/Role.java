package com.example.pathfinder.models.entityModels;

import com.example.pathfinder.models.entityModels.enums.LevelEnum;
import com.example.pathfinder.models.entityModels.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleEnum getName() {
        return name;
    }

    public Role setName(RoleEnum name) {
        this.name = name;
        return this;
    }
}
