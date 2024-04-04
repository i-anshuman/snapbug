package com.snapbug.services;

import com.snapbug.dtos.ScreenCreationDTO;
import com.snapbug.dtos.ScreenDTO;

import java.util.List;

public interface IScreenService {
  ScreenDTO save(ScreenCreationDTO screen);
  List<ScreenDTO> getAll();
  List<ScreenDTO> getAll(Long subModuleId);
  void delete(Long screenId);
  ScreenDTO update(ScreenDTO screen);
}
