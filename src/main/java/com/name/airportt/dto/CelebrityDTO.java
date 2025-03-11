package com.name.airportt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelebrityDTO {
    private int id;
    private String name;
    private String profession;
    private Double netWorth;
    private Boolean suspiciousActivity;
}
