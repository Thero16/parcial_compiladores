package com.name.airportt.controller;

import com.name.airportt.dto.CelebrityDTO;
import com.name.airportt.service.ICelebrityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/celebrities")
public class CelebrityController {
    @Autowired
    ICelebrityService celebrityService;

    @PostMapping("/")
    public CelebrityDTO addCelebrity(@Valid @RequestBody CelebrityDTO celebrityDTO) {
        return celebrityService.addCelebrity(celebrityDTO);
    }

    @GetMapping("/{id}")
    public Optional<CelebrityDTO> buscarCelebrity(@PathVariable int id) {
        return celebrityService.getCelebrityById(id);
    }

    @PatchMapping("/{id}")
    public CelebrityDTO updateCelebrity(@Valid @PathVariable int id, @RequestBody CelebrityDTO celebrityDTO) {
        return celebrityService.updateCelebrity(id, celebrityDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCelebrity(@PathVariable int id) {
        celebrityService.deleteCelebrity(id);
    }
}
