package com.snapbug.repositories;

import com.snapbug.entities.Screen;
import com.snapbug.entities.SubModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScreenRepository extends JpaRepository<Screen, Long> {
  List<Screen> findBySubModule(SubModule subModule);
}
