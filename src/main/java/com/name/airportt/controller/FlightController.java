package com.name.airportt.controller;

import com.name.airportt.dto.FlightDTO;
import com.name.airportt.dto.PrivateJetDTO;
import com.name.airportt.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/")
    public FlightDTO addFlight(@Valid @RequestBody FlightDTO flightDTO) {
        return flightService.addFlight(flightDTO);
    }

    @GetMapping("/{id}")
    public Optional<FlightDTO> getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    @GetMapping("/suspicious")
    public ResponseEntity<List<FlightDTO>> getSuspiciousFlights() {
        List<FlightDTO> suspiciousFlights = flightService.getSuspiciousFlights();
        return ResponseEntity.ok(suspiciousFlights);
    }
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
    }

}
