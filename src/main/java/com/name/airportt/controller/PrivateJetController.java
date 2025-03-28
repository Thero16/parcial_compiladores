package com.name.airportt.controller;

import com.name.airportt.dto.PrivateJetDTO;
import com.name.airportt.service.IPrivateJetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/private_jets")
public class PrivateJetController {

    @Autowired
    IPrivateJetService privateJetService;

    @PostMapping("/")
    public PrivateJetDTO addPrivateJet(@Valid @RequestBody PrivateJetDTO privateJetDTO) {
        return privateJetService.addPrivateJet(privateJetDTO);
    }

    @GetMapping("/buscar/{id}")
    public Optional<PrivateJetDTO> getPrivateJetById(@PathVariable int id) {
        return privateJetService.getPrivateJetById(id);
    }

    @PatchMapping("/actualizar/{id}")
    public PrivateJetDTO updatePrivateJet(@Valid @PathVariable int id, @RequestBody PrivateJetDTO privateJetDTO) {
        return privateJetService.updatePrivateJet(id, privateJetDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deletePrivateJet(@PathVariable int id) {
        privateJetService.deletePrivateJet(id);
    }
}