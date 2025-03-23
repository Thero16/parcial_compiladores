package com.name.airportt.service;

import com.name.airportt.dto.CelebrityDTO;
import com.name.airportt.exceptions.InvalidDataException;
import com.name.airportt.exceptions.NotFoundException;
import com.name.airportt.model.Celebrity;
import com.name.airportt.repository.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CelebrityService implements ICelebrityService{


    @Autowired
    CelebrityRepository celebrityRepository;

    @Override
    public CelebrityDTO addCelebrity(CelebrityDTO celebrityDTO) {

        if(celebrityDTO.getName()==null || celebrityDTO.getProfession()==null){
            throw new InvalidDataException("Name and profession are required");
        }

        Celebrity celebrity = new Celebrity();
        celebrity.setName(celebrityDTO.getName());
        celebrity.setProfession(celebrityDTO.getProfession());
        celebrity.setNetWorth(celebrityDTO.getNetWorth());
        celebrity.setSuspiciousActivity(celebrityDTO.getSuspiciousActivity());
        celebrityRepository.save(celebrity);
        return convertirADTO(celebrity);
    }

    @Override
    public Optional<CelebrityDTO> getCelebrityById(int id) {
        Celebrity celebrity = celebrityRepository.findById(id).orElseThrow(()->new NotFoundException("Celebrity not found with id"+id));
        return Optional.ofNullable(convertirADTO(celebrity));
    }

    @Override
    public CelebrityDTO updateCelebrity(int id, CelebrityDTO celebrityDTO) {
        Optional<Celebrity> existingCelebrityOpt = celebrityRepository.findById(id);

        if (existingCelebrityOpt.isPresent()) {
            Celebrity existingCelebrity = existingCelebrityOpt.get();

            if (celebrityDTO.getName() != null) {
                existingCelebrity.setName(celebrityDTO.getName());
            }
            if (celebrityDTO.getProfession() != null) {
                existingCelebrity.setProfession(celebrityDTO.getProfession());
            }
            if (celebrityDTO.getNetWorth() != null) {
                existingCelebrity.setNetWorth(celebrityDTO.getNetWorth());
            }
            if (celebrityDTO.getSuspiciousActivity() != null) {
                existingCelebrity.setSuspiciousActivity(celebrityDTO.getSuspiciousActivity());
            }

            celebrityRepository.save(existingCelebrity);
            return convertirADTO(existingCelebrity);
        } else {
            throw new NotFoundException("Celebrity not found with id"+id);
        }
    }

    @Override
    public void deleteCelebrity(int id) {
        if (celebrityRepository.existsById(id)) {
            celebrityRepository.deleteById(id);
        } else {
            throw new NotFoundException("Celebrity not found with id"+id);
        }
    }

    public CelebrityDTO convertirADTO(Celebrity celebrity) {
        return new CelebrityDTO(celebrity.getId(), celebrity.getName(), celebrity.getProfession(), celebrity.getNetWorth(), celebrity.getSuspiciousActivity());
    }


}
