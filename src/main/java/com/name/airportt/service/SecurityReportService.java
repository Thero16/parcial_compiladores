package com.name.airportt.service;

import com.name.airportt.dto.SecurityReportDto;
import com.name.airportt.exceptions.InvalidDataException;
import com.name.airportt.exceptions.NotFoundException;
import com.name.airportt.model.Flight;
import com.name.airportt.model.SecurityReport;
import com.name.airportt.repository.FlightRepository;
import com.name.airportt.repository.SecurityReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityReportService implements ISecurityReportService {

    @Autowired
    private SecurityReportRepository securityReportRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public SecurityReportDto addSecurityReport(SecurityReportDto securityReportDto) {
        if(securityReportDto.getFlightId()==null || securityReportDto.getReportedBy()==null || securityReportDto.getDescription()==null){
            throw new InvalidDataException("Missing required fields");
        }
        Optional<Flight> flight = flightRepository.findById(securityReportDto.getFlightId());
        if(flight.isEmpty()){
            throw new NotFoundException("Flight not found with id: " + securityReportDto.getFlightId());
        }

        SecurityReport securityReport = new SecurityReport();
        securityReport.setFlight(flight.get());
        securityReport.setReportedBy(securityReportDto.getReportedBy());
        securityReport.setDescription(securityReportDto.getDescription());
        securityReport.setResolved(securityReportDto.getIsResolved());
        securityReportRepository.save(securityReport);

        return convertirADto(securityReport);

    }

    @Override
    public List<SecurityReportDto> getUnresolvedReports() {
        List<SecurityReport> unresolvedReports= securityReportRepository.findByIsResolvedFalse();
        return unresolvedReports.stream()
                .map(this::convertirADto)
                .toList();
    }

    @Override
    public SecurityReportDto markReportAsResolved(int id) {
        Optional<SecurityReport> securityReportOpt = securityReportRepository.findById(id);
        if(securityReportOpt.isPresent()){
            SecurityReport securityReport = securityReportOpt.get();
            securityReport.setResolved(true);
            securityReportRepository.save(securityReport);
            return convertirADto(securityReport);
        } else {
            throw new NotFoundException("SecurityReport not found with id: " + id);
        }
    }

    public SecurityReportDto convertirADto(SecurityReport securityReport){
        return new SecurityReportDto(securityReport.getId(), securityReport.getFlight().getId(), securityReport.getReportedBy(), securityReport.getDescription(), securityReport.isResolved());
    }
}
