package com.name.airportt.service;

import com.name.airportt.dto.PrivateJetDTO;
import com.name.airportt.model.Celebrity;
import com.name.airportt.model.PrivateJet;
import com.name.airportt.repository.PrivateJetRepository;
import com.name.airportt.repository.CelebrityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrivateJetService implements IPrivateJetService {

    @Autowired
    private PrivateJetRepository privateJetRepository;

    @Autowired
    private CelebrityRepository celebrityRepository;

    @Override
    @Transactional
    public PrivateJetDTO addPrivateJet(PrivateJetDTO jetDTO) {
        Optional<Celebrity> owner = celebrityRepository.findById(jetDTO.getOwner_id());
        if (owner.isEmpty()) {
            throw new IllegalArgumentException("Owner with ID " + jetDTO.getOwner_id() + " not found");
        }

        PrivateJet jet = new PrivateJet();
        jet.setModel(jetDTO.getModel());
        jet.setCapacity(jetDTO.getCapacity());
        jet.setOwner(owner.get());

        PrivateJet savedJet = privateJetRepository.save(jet);

        return new PrivateJetDTO(savedJet.getId(), savedJet.getModel(), savedJet.getCapacity(), savedJet.getOwner().getId());
    }

    @Override
    public Optional<PrivateJetDTO> getPrivateJetById(int id) {
        return privateJetRepository.findById(id)
                .map(jet -> new PrivateJetDTO(jet.getId(), jet.getModel(), jet.getCapacity(), jet.getOwner().getId()));
    }

    @Override
    public PrivateJetDTO updatePrivateJet(int id, PrivateJetDTO jetDTO) {
        Optional<PrivateJet> existingJet = privateJetRepository.findById(id);
        if (existingJet.isEmpty()) {
            throw new IllegalArgumentException("Jet with ID " + id + " not found");
        }

        Optional<Celebrity> owner = celebrityRepository.findById(jetDTO.getOwner_id());
        if (owner.isEmpty()) {
            throw new IllegalArgumentException("Owner with ID " + jetDTO.getOwner_id() + " not found");
        }

        PrivateJet jet = existingJet.get();
        jet.setModel(jetDTO.getModel());
        jet.setCapacity(jetDTO.getCapacity());
        jet.setOwner(owner.get());

        PrivateJet updatedJet = privateJetRepository.save(jet);
        return new PrivateJetDTO(updatedJet.getId(), updatedJet.getModel(), updatedJet.getCapacity(), updatedJet.getOwner().getId());
    }

    @Override
    public void deletePrivateJet(int id) {
        privateJetRepository.deleteById(id);
    }
}
