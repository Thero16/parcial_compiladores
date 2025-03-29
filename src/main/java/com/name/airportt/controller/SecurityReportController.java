package com.name.airportt.controller;

import com.name.airportt.dto.SecurityReportDto;
import com.name.airportt.service.SecurityReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security-reports")
public class SecurityReportController {
    @Autowired
    private SecurityReportService securityReportService;

    @PostMapping("/")
    public SecurityReportDto addSecurityReport(@Valid @RequestBody SecurityReportDto securityReportDto) {
        return securityReportService.addSecurityReport(securityReportDto);
    }

    @GetMapping("/unresolved")
    public List<SecurityReportDto> getUnresolvedSecurityReports() {
        return securityReportService.getUnresolvedReports();
    }

    @PatchMapping("/{id}/resolve")
    public SecurityReportDto resolveSecurityReport(@Valid @PathVariable int id) {
        return securityReportService.markReportAsResolved(id);
    }
}
