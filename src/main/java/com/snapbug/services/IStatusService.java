package com.snapbug.services;

import com.snapbug.dtos.StatusCreationDTO;
import com.snapbug.dtos.StatusDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IStatusService {

  @PreAuthorize("hasAuthority('status:create')")
  StatusDTO save(StatusCreationDTO status);

  @PreAuthorize("hasAuthority('status:read')")
  List<StatusDTO> getAll();

  @PreAuthorize("hasAuthority('status:delete')")
  void delete(Long statusId);

  @PreAuthorize("hasAuthority('status:update')")
  StatusDTO update(StatusDTO status);
}
