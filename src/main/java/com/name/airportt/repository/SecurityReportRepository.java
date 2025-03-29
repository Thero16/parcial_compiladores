package com.name.airportt.repository;

import com.name.airportt.model.SecurityReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityReportRepository extends JpaRepository<SecurityReport, Integer> {
    List<SecurityReport> findByIsResolvedFalse();
}
