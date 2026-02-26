package com.example.Thymeleaf.Demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fighters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Fighter name is required")
    @Size(min = 2, max = 240, message = "Fighter name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "health is required")
    @Min(value = 1001, message = "health must be greater than 1000")
    @Max(value = 1499 , message = "health must be less than 1500")
    private Integer health;

    @NotNull(message = "damage is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "damage must be at least 0")
    @DecimalMax(value = "99.99", inclusive = true, message = "damage must be less than 100")
    private Double damage;

    @NotNull(message = "Resistance is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Resistance must be at least 0")
    @DecimalMax(value = "10" , inclusive = true, message = "Resistance must be less than 10")
    private Double resistance;


}
