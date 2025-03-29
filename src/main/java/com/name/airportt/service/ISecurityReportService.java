package com.name.airportt.service;

import com.name.airportt.dto.SecurityReportDto;

import java.util.List;

public interface ISecurityReportService {
    public SecurityReportDto addSecurityReport(SecurityReportDto securityReportDto);
    public List<SecurityReportDto> getUnresolvedReports();
    public SecurityReportDto markReportAsResolved(int id);

}
