package com.example.Thymeleaf.Demo.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Health is required")
    @Min(value = 1000, message = "Health must be at least 1000")
    @Max(value = 1499, message = "Health must be less than 1500")
    private Integer health;

    @NotNull(message = "Damage is required")
    @Max(value = 99, message = "Damage must be less than 100")
    private Double damage;

    @NotNull(message = "Resistance is required")
    @DecimalMin(value = "0.0", message = "Resistance must be >= 0.0")
    @DecimalMax(value = "10.0", message = "Resistance must be <= 10.0")
    private Double resistance;
}

