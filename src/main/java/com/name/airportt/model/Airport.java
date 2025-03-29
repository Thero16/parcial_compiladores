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
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "location is required")
    private String location;
    @NotBlank(message = "capacity is required")
    private int capacity;
    private String owners;
}
