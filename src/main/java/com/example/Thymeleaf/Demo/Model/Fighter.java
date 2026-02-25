package com.example.Thymeleaf.Demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "fighters")
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Health is required")
    @Min(value = 1001, message = "Health must be more than 1000")
    @Max(value = 1499, message = "Health must be less than 1500")
    private Integer health;

    @NotNull(message = "Damage is required")
    @Max(value = 99, message = "Damage must be less than 100")
    private Integer damage;

    @NotNull(message = "Resistance is required")
    @DecimalMin(value = "0.0", message = "Resistance must be from 0 to 10")
    @DecimalMax(value = "10.0", message = "Resistance must be from 0 to 10")
    private Double resistance;

    // Default constructor (required by JPA)
    public Fighter() {}

    public Fighter(String name, Integer health, Integer damage, Double resistance) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.resistance = resistance;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getHealth() { return health; }
    public void setHealth(Integer health) { this.health = health; }

    public Integer getDamage() { return damage; }
    public void setDamage(Integer damage) { this.damage = damage; }

    public Double getResistance() { return resistance; }
    public void setResistance(Double resistance) { this.resistance = resistance; }
}