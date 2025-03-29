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
@Tag(name = "Aeropuertos", description = "Operaciones de consulta sobre aeropuertos")
public class AirportController {

    @Autowired
    private IAirportService airportService;

    @GetMapping("/")
    @Operation(summary = "Obtener todos los aeropuertos",
            description = "Devuelve una lista completa de todos los aeropuertos disponibles en el sistema")
    public List<AirportDto> getAirports() {
        return airportService.getAirports();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar aeropuerto por ID",
            description = "Obtiene la información detallada de un aeropuerto específico mediante su identificador único")
    public Optional<AirportDto> getAirportById(@PathVariable int id) {
        return airportService.getAirportById(id);
    }
}