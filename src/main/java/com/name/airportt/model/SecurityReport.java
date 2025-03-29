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
@Table(name = "security_report")
public class SecurityReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
    @NotBlank(message = "Reported by is required")
    private String reportedBy;
    @NotBlank(message = "Description is required")
    private String description;
    private boolean isResolved;
}
