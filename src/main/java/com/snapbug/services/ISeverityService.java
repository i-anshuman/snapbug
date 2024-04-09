package com.snapbug.services;

import com.snapbug.dtos.SeverityCreationDTO;
import com.snapbug.dtos.SeverityDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ISeverityService {

  @PreAuthorize("hasAuthority('severity:create')")
  SeverityDTO save(SeverityCreationDTO severity);

  @PreAuthorize("hasAuthority('severity:read')")
  List<SeverityDTO> getAll();

  @PreAuthorize("hasAuthority('severity:delete')")
  void delete(Long severityId);

  @PreAuthorize("hasAuthority('severity:update')")
  SeverityDTO update(SeverityDTO severity);
}
