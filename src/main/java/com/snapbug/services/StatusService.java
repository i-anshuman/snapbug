package com.snapbug.services;

import com.snapbug.dtos.StatusCreationDTO;
import com.snapbug.dtos.StatusDTO;
import com.snapbug.entities.Status;
import com.snapbug.mappers.StatusMapper;
import com.snapbug.repositories.IStatusRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StatusService implements IStatusService {

  private final IStatusRepository statusRepository;
  private final StatusMapper statusMapper;

  public StatusService(IStatusRepository statusRepository, StatusMapper statusMapper) {
    this.statusRepository = statusRepository;
    this.statusMapper = statusMapper;
  }

  @Override
  public StatusDTO save(StatusCreationDTO status) {
    final Status model = statusRepository.save(statusMapper.dtoToModel(status));
    return statusMapper.modelToDto(model);
  }

  @Override
  public List<StatusDTO> getAll() {
    return statusRepository
            .findAll()
            .stream()
            .map(statusMapper::modelToDto)
            .toList();
  }

  @Override
  public void delete(Long statusId) {
    statusRepository.deleteById(statusId);
  }

  @Override
  public StatusDTO update(StatusDTO status) {
    final Status model = statusRepository.save(statusMapper.dtoToModel(status));
    return statusMapper.modelToDto(model);
  }
}
