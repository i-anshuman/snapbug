package com.snapbug.services;

import com.snapbug.dtos.ScreenCreationDTO;
import com.snapbug.dtos.ScreenDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IScreenService {
  @PreAuthorize("hasAuthority('screen:create')")
  ScreenDTO save(ScreenCreationDTO screen);

  @PreAuthorize("hasAuthority('screen:read')")
  List<ScreenDTO> getAll();

  @PreAuthorize("hasAuthority('screen:read')")
  List<ScreenDTO> getAll(Long subModuleId);

  @PreAuthorize("hasAuthority('screen:delete')")
  void delete(Long screenId);

  @PreAuthorize("hasAuthority('screen:update')")
  ScreenDTO update(ScreenDTO screen);
}
