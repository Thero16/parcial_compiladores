package com.name.airportt.controller;

import com.name.airportt.dto.CelebrityDTO;
import com.name.airportt.service.ICelebrityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/celebrities")
@Tag(name = "Celebridades", description = "Operaciones para gestionar celebridades del aeropuerto")
public class CelebrityController {

    @Autowired
    ICelebrityService celebrityService;

    @PostMapping("/")
    @Operation(summary = "Crear celebridad", description = "Registra una nueva celebridad en el sistema")
    public CelebrityDTO addCelebrity(@Valid @RequestBody CelebrityDTO celebrityDTO) {
        return celebrityService.addCelebrity(celebrityDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener celebridad", description = "Recupera los datos de una celebridad por su ID")
    public Optional<CelebrityDTO> buscarCelebrity(@PathVariable int id) {
        return celebrityService.getCelebrityById(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar celebridad", description = "Modifica los datos de una celebridad existente")
    public CelebrityDTO updateCelebrity(@Valid @PathVariable int id, @RequestBody CelebrityDTO celebrityDTO) {
        return celebrityService.updateCelebrity(id, celebrityDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar celebridad", description = "Remueve permanentemente una celebridad del sistema")
    public void deleteCelebrity(@PathVariable int id) {
        celebrityService.deleteCelebrity(id);
    }
}