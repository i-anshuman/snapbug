package com.snapbug.services;

import com.snapbug.dtos.StatusCreationDTO;
import com.snapbug.dtos.StatusDTO;

import java.util.List;

public interface IStatusService {
  StatusDTO save(StatusCreationDTO status);
  List<StatusDTO> getAll();
  void delete(Long statusId);
  StatusDTO update(StatusDTO status);
}
