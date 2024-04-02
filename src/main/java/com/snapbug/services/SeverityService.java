package com.snapbug.services;

import com.snapbug.dtos.SeverityCreationDTO;
import com.snapbug.dtos.SeverityDTO;
import com.snapbug.entities.Severity;
import com.snapbug.mappers.SeverityMapper;
import com.snapbug.repositories.ISeverityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SeverityService implements ISeverityService {

  private final ISeverityRepository severityRepository;
  private final SeverityMapper severityMapper;

  @Autowired
  public SeverityService(ISeverityRepository severityRepository, SeverityMapper severityMapper) {
    this.severityRepository = severityRepository;
    this.severityMapper = severityMapper;
  }


  @Override
  public SeverityDTO save(SeverityCreationDTO severity) {
    final Severity model = severityRepository.save(severityMapper.dtoToModel(severity));
    return severityMapper.modelToDto(model);
  }

  @Override
  public List<SeverityDTO> getAll() {
    return severityRepository
            .findAll()
            .stream()
            .map(severityMapper::modelToDto)
            .toList();
  }

  @Override
  public void delete(Long severityId) {
    severityRepository.deleteById(severityId);
  }

  @Override
  public SeverityDTO update(SeverityDTO severity) {
    final Severity model = severityRepository.save(severityMapper.dtoToModel(severity));
    return severityMapper.modelToDto(model);
  }
}
