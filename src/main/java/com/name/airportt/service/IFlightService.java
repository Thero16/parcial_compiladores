package com.name.airportt.service;

import com.name.airportt.dto.FlightDTO;

import java.util.List;
import java.util.Optional;

public interface IFlightService {
    public FlightDTO addFlight(FlightDTO flightDTO);
    Optional<FlightDTO> getFlightById(int id);
    public List<FlightDTO> getSuspiciousFlights();
    void deleteFlight(int id);
}
