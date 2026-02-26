package com.example.Thymeleaf.Demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fighter {

    // ======================
    // Fields (Database Columns)
    // ======================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer health;

    private Integer damage;

    private Double resistance;

    // ======================
    // Constructors
    // ======================

    public Fighter() {
        // REQUIRED by Spring & JPA
    }

    public Fighter(String name, Integer health, Integer damage, Double resistance) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.resistance = resistance;
    }

    // ======================
    // Getters & Setters
    // ======================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Double getResistance() {
        return resistance;
    }

    public void setResistance(Double resistance) {
        this.resistance = resistance;
    }
}