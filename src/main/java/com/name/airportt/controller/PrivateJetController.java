package com.name.airportt.controller;

import com.name.airportt.dto.PrivateJetDTO;
import com.name.airportt.service.IPrivateJetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/jets")
@Tag(name = "Jets Privados", description = "Operaciones CRUD para la gestión de jets privados")
public class PrivateJetController {

    @Autowired
    private IPrivateJetService privateJetService;

    @PostMapping("/")
    @Operation(summary = "Agregar jet privado",
            description = "Registra un nuevo jet privado en el sistema")
    public PrivateJetDTO addPrivateJet(@Valid @RequestBody PrivateJetDTO privateJetDTO) {
        return privateJetService.addPrivateJet(privateJetDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener jet por ID",
            description = "Recupera la información de un jet privado específico usando su ID")
    public Optional<PrivateJetDTO> getPrivateJetById(@PathVariable int id) {
        return privateJetService.getPrivateJetById(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar jet privado",
            description = "Modifica la información de un jet privado existente")
    public PrivateJetDTO updatePrivateJet(@Valid @PathVariable int id,
                                          @RequestBody PrivateJetDTO privateJetDTO) {
        return privateJetService.updatePrivateJet(id, privateJetDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar jet privado",
            description = "Remueve permanentemente un jet privado del sistema")
    public void deletePrivateJet(@PathVariable int id) {
        privateJetService.deletePrivateJet(id);
    }
}