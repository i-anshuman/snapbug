package com.snapbug.services;

import com.snapbug.dtos.SeverityCreationDTO;
import com.snapbug.dtos.SeverityDTO;

import java.util.List;

public interface ISeverityService {
  SeverityDTO save(SeverityCreationDTO severity);
  List<SeverityDTO> getAll();
  void delete(Long severityId);
  SeverityDTO update(SeverityDTO severity);
}
