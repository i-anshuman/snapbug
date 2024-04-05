package com.snapbug.services;

import com.snapbug.dtos.ScreenCreationDTO;
import com.snapbug.dtos.ScreenDTO;
import com.snapbug.entities.Screen;
import com.snapbug.mappers.ScreenMapper;
import com.snapbug.repositories.IScreenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ScreenService implements IScreenService {

  private final IScreenRepository screenRepository;
  private final ScreenMapper screenMapper;

  public ScreenService(IScreenRepository screenRepository, ScreenMapper screenMapper) {
    this.screenRepository = screenRepository;
    this.screenMapper = screenMapper;
  }

  @Override
  public ScreenDTO save(ScreenCreationDTO screen) {
    final Screen model = screenRepository.save(screenMapper.dtoToModel(screen));
    return screenMapper.modelToDto(model);
  }

  @Override
  public List<ScreenDTO> getAll() {
    return screenRepository
            .getAll()
            .stream()
            .toList();
  }

  @Override
  public List<ScreenDTO> getAll(Long subModuleId) {
    return screenRepository
            .getBySubModule(subModuleId)
            .stream()
            .toList();
  }

  @Override
  public void delete(Long screenId) {
    screenRepository.deleteById(screenId);
  }

  @Override
  public ScreenDTO update(ScreenDTO screen) {
    final Screen model = screenRepository.save(screenMapper.dtoToModel(screen));
    return screenMapper.modelToDto(model);
  }
}
