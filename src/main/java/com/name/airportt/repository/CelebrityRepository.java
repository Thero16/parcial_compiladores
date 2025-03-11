package com.name.airportt.repository;

import com.name.airportt.model.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CelebrityRepository extends JpaRepository<Celebrity, Integer> {
}
