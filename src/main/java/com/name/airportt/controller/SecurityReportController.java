package com.name.airportt.controller;

import com.name.airportt.dto.SecurityReportDto;
import com.name.airportt.service.SecurityReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security-reports")
@Tag(name = "Informes de Seguridad", description = "Gestión de reportes de seguridad del aeropuerto")
public class SecurityReportController {

    @Autowired
    private SecurityReportService securityReportService;

    @PostMapping("/")
    @Operation(summary = "Crear informe de seguridad",
            description = "Registra un nuevo informe sobre incidentes de seguridad en el aeropuerto")
    public SecurityReportDto addSecurityReport(@Valid @RequestBody SecurityReportDto securityReportDto) {
        return securityReportService.addSecurityReport(securityReportDto);
    }

    @GetMapping("/unresolved")
    @Operation(summary = "Obtener informes no resueltos",
            description = "Lista todos los reportes de seguridad que aún no han sido marcados como resueltos")
    public List<SecurityReportDto> getUnresolvedSecurityReports() {
        return securityReportService.getUnresolvedReports();
    }

    @PatchMapping("/{id}/resolve")
    @Operation(summary = "Resolver informe",
            description = "Marca un informe de seguridad específico como resuelto mediante su ID")
    public SecurityReportDto resolveSecurityReport(@Valid @PathVariable int id) {
        return securityReportService.markReportAsResolved(id);
    }
}