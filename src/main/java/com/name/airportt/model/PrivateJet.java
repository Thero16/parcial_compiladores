package com.name.airportt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "private_jets")
public class PrivateJet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "model is required")
    private String model;
    @NotNull(message = "capacity is required")
    @Min(1)
    private int capacity;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Celebrity owner;
}
