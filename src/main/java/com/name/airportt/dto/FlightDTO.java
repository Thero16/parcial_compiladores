package com.name.airportt.dto;

import com.name.airportt.enums.Purpose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private int id;
    private int celebrity_id;
    private int jet_id;
    private String departure_airport;
    private String arrival_airport;
    private Timestamp departure_time;
    private Timestamp arrival_time;
    private Purpose purpose;
}
