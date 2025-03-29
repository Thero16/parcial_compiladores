package com.name.airportt.controller;

import com.name.airportt.dto.FlightDTO;
import com.name.airportt.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
@Tag(name = "Vuelos", description = "Operaciones para la gestión de vuelos")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/")
    @Operation(summary = "Agregar vuelo",
            description = "Registra un nuevo vuelo en el sistema con los datos proporcionados")
    public FlightDTO addFlight(@Valid @RequestBody FlightDTO flightDTO) {
        return flightService.addFlight(flightDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener vuelo por ID",
            description = "Recupera la información detallada de un vuelo específico usando su ID único")
    public Optional<FlightDTO> getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    @GetMapping("/suspicious")
    @Operation(summary = "Obtener vuelos sospechosos",
            description = "Devuelve una lista de vuelos marcados como sospechosos por el sistema")
    public ResponseEntity<List<FlightDTO>> getSuspiciousFlights() {
        List<FlightDTO> suspiciousFlights = flightService.getSuspiciousFlights();
        return ResponseEntity.ok(suspiciousFlights);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar vuelo",
            description = "Elimina permanentemente un vuelo del sistema usando su ID")
    public void deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
    }
}