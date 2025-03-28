package com.name.airportt.service;

import com.name.airportt.dto.FlightDTO;
import com.name.airportt.model.Celebrity;
import com.name.airportt.model.Flight;
import com.name.airportt.model.PrivateJet;
import com.name.airportt.enums.Purpose;
import com.name.airportt.repository.CelebrityRepository;
import com.name.airportt.repository.FlightRepository;
import com.name.airportt.repository.PrivateJetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CelebrityRepository celebrityRepository;

    @Autowired
    private PrivateJetRepository privateJetRepository;

    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        Optional<Celebrity> celebrity= celebrityRepository.findById(flightDTO.getCelebrity_id());
            if(celebrity.isEmpty()){
                throw new IllegalArgumentException("Celebrity with ID"+ flightDTO.getCelebrity_id()+" not found ");
            }
        Optional<PrivateJet> jet= privateJetRepository.findById(flightDTO.getJet_id());
            if(jet.isEmpty()){
                throw new IllegalArgumentException("Jet with ID"+flightDTO.getJet_id()+" not found");
            }

        Purpose purpose;
        try {
            purpose = Purpose.fromString(String.valueOf(flightDTO.getPurpose()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid purpose. Allowed values: BUSINESS, VACATION, SUSPICIOUS");
        }


        Flight flight= new Flight();

        flight.setCelebrity(celebrity.get());
        flight.setPrivateJet(jet.get());
        flight.setDeparture_airport(flightDTO.getDeparture_airport());
        flight.setArrival_airport(flightDTO.getArrival_airport());
        flight.setDeparture_time(flightDTO.getDeparture_time());
        flight.setArrival_time(flightDTO.getArrival_time());
        flight.setPurpose(flightDTO.getPurpose());

        Flight savedFlight = flightRepository.save(flight);

        return new FlightDTO(savedFlight.getId(),savedFlight.getCelebrity().getId(), savedFlight.getPrivateJet().getId(),savedFlight.getDeparture_airport(),savedFlight.getArrival_airport(),savedFlight.getDeparture_time(),savedFlight.getArrival_time(),savedFlight.getPurpose());
    }

    @Override
    public Optional <FlightDTO> getFlightById(int id) {
        return flightRepository.findById(id)
                .map(flight-> new FlightDTO( flight.getId(), flight.getCelebrity().getId(), flight.getPrivateJet().getId(), flight.getDeparture_airport(),flight.getArrival_airport(),flight.getDeparture_time(),flight.getArrival_time(),flight.getPurpose()));

    }

    @Override
    public List<FlightDTO> getSuspiciousFlights() {
            List<Flight> suspiciousFlights = flightRepository.findByPurpose(Purpose.SUSPICIOUS);

            if (suspiciousFlights.isEmpty()) {
                throw new IllegalArgumentException("No suspicious flights found");
            }

            return suspiciousFlights.stream()
                    .map(flight -> new FlightDTO(
                            flight.getId(),
                            flight.getCelebrity().getId(),
                            flight.getPrivateJet().getId(),
                            flight.getDeparture_airport(),
                            flight.getArrival_airport(),
                            flight.getDeparture_time(),
                            flight.getArrival_time(),
                            flight.getPurpose()
                    ))
                    .collect(Collectors.toList());

    }



    @Override
    public void deleteFlight(int id){
        flightRepository.deleteById(id);
    }

}
