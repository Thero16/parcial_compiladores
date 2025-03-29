package com.name.airportt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityReportDto {
    private int id;
    private Integer flightId;
    private String reportedBy;
    private String description;
    private Boolean isResolved= false;
}
