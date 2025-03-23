package com.name.airportt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDto {

    private int id;
    private String name;
    private String location;
    private int capacity;
    private String owners="Sofia and Natalia the worst owners >:(";
}
