package com.name.airportt.repository;

import com.name.airportt.enums.Purpose;
import com.name.airportt.model.Celebrity;
import com.name.airportt.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {

    List<Flight> findByPurpose(Purpose purpose);
}
