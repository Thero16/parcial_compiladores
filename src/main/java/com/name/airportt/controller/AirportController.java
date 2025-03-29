package com.name.airportt.controller;

import com.name.airportt.dto.AirportDto;
import com.name.airportt.service.IAirportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    @Autowired
    IAirportService airportService;

    @GetMapping("/")
    public List<AirportDto> getAiports(){
        return airportService.getAirports();
    }

    @GetMapping("/{id}")
    public Optional getAirportById(@PathVariable int id){
        return airportService.getAirportById(id);
    }
}
