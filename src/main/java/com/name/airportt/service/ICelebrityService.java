package com.name.airportt.service;

import com.name.airportt.dto.CelebrityDTO;

import java.util.Optional;

public interface ICelebrityService {
    public CelebrityDTO addCelebrity(CelebrityDTO celebrityDTO);
    Optional<CelebrityDTO> getCelebrityById(int id);
    public CelebrityDTO updateCelebrity(int id, CelebrityDTO celebrityDTO);
    public void deleteCelebrity(int id);
}
