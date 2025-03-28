package com.name.airportt.model;


import com.name.airportt.enums.Purpose;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "celebrity_id", nullable = false)
    private Celebrity celebrity;
    @ManyToOne
    @JoinColumn(name = "jet_id", nullable = false)
    private PrivateJet privateJet;

    @NotBlank(message = "departure airport is required")
    private String departure_airport;
    @NotBlank(message = "arrival airport is required")
    private String arrival_airport;

    @NotNull(message = "departure time is required")
    private Timestamp departure_time;

    @NotNull(message = "arrival time is required")
    private Timestamp arrival_time;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "purpose is required")
    private Purpose purpose;

}
