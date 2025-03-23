package com.name.airportt.service;

import com.name.airportt.dto.AirportDto;

import java.util.List;
import java.util.Optional;

public interface IAirportService {

    public List<AirportDto> getAirports();
    Optional<AirportDto> getAirportById(int id);

}
