package com.name.airportt.service;


import com.name.airportt.dto.PrivateJetDTO;

import java.util.Optional;

public interface IPrivateJetService {
    PrivateJetDTO addPrivateJet(PrivateJetDTO jet);
    Optional<PrivateJetDTO> getPrivateJetById(int id);
    PrivateJetDTO updatePrivateJet(int id, PrivateJetDTO jet);
    void deletePrivateJet(int id);
}
