package com.name.airportt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "celebrities")
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "profession is required")
    private String profession;
    private Double netWorth;
    private Boolean suspiciousActivity;

}
