package com.name.airportt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivateJetDTO {
    private int id;
    private String model;
    private int capacity;
    private int owner_id;
}
