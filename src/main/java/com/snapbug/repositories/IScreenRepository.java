package com.snapbug.repositories;

import com.snapbug.dtos.ScreenDTO;
import com.snapbug.entities.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScreenRepository extends JpaRepository<Screen, Long> {
  List<ScreenDTO> getAll();
  List<ScreenDTO> getBySubModule(Long subModuleId);
}
