package com.name.airportt.service;

import com.name.airportt.dto.AirportDto;
import com.name.airportt.exceptions.NotFoundException;
import com.name.airportt.model.Airport;
import com.name.airportt.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService{
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<AirportDto> getAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream().map(this::convertirADto).collect(Collectors.toList());
    }

    @Override
    public Optional<AirportDto> getAirportById(int id) {
        Airport airport = airportRepository.findById(id).orElseThrow(()->new NotFoundException("Airport not found with id: " + id));
        return Optional.ofNullable(convertirADto(airport));

    }

    public AirportDto convertirADto(Airport airport){
        return new AirportDto(airport.getId(), airport.getName(), airport.getLocation(), airport.getCapacity(), airport.getOwners());
    }
}
