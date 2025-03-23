package com.name.airportt.controller;

import com.name.airportt.dto.AirportDto;
import com.name.airportt.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    IAirportService airportService;

    @GetMapping("/")
    public List<AirportDto> getAiports(){
        return airportService.getAirports();
    }

    @GetMapping("/buscar/{id}")
    public Optional getAirportById(@PathVariable int id){
        return airportService.getAirportById(id);
    }
}
